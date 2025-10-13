// scripts/update_recent_any.js
// 깃 커밋 히스토리를 기준으로 백준/프로그래머스/SWEA 최신 풀이 N개를 README에 반영
// 로그인/크롤링 불필요. 파일/폴더명 규칙이 들쑥날쑥해도 최대한 파싱해서 표 생성.

import fs from "fs";
import path from "path";
import { execSync } from "child_process";
import { fileURLToPath } from "url";

const __filename = fileURLToPath(import.meta.url);
const __dirname = path.dirname(__filename);

// === 설정 ===
const ROOT = path.resolve(__dirname, "..");
const README_PATH = path.resolve(ROOT, "README.md");
const MARK_START = "<!-- RECENT_PROBLEMS:start -->";
const MARK_END = "<!-- RECENT_PROBLEMS:end -->";
const RECENT_COUNT = parseInt(process.env.RECENT_COUNT || "7", 10);

// 스캔할 디렉토리(플랫폼 매핑)
const TARGETS = [
  { dir: "백준", platform: "BOJ" },
  { dir: "프로그래머스", platform: "Programmers" },
  { dir: "SWEA", platform: "SWEA" },
];

// 링크 템플릿(문제 번호가 파싱되면 사용)
const LINK_TEMPLATE = {
  BOJ: (id) => `https://www.acmicpc.net/problem/${id}`,
  Programmers: (id) => `https://school.programmers.co.kr/learn/courses/30/lessons/${id}`,
  SWEA: (id) => `https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=${id}`,
};

// 파일 확장자 필터
const ALLOWED_EXT = new Set([".java", ".kt", ".py", ".cpp", ".js", ".md", ".txt"]);

function run(cmd) {
  return execSync(cmd, { stdio: ["ignore", "pipe", "ignore"] }).toString().trim();
}

function listFilesRec(dirAbs) {
  const out = [];
  function walk(p) {
    const ents = fs.existsSync(p) ? fs.readdirSync(p, { withFileTypes: true }) : [];
    for (const e of ents) {
      const cur = path.join(p, e.name);
      if (e.isDirectory()) walk(cur);
      else {
        const ext = path.extname(e.name).toLowerCase();
        if (ALLOWED_EXT.has(ext)) out.push(cur);
      }
    }
  }
  walk(dirAbs);
  return out;
}

function safeStat(fileAbs) {
  try {
    const iso = run(`git log -1 --format=%ci -- "${fileAbs}"`);
    // %ci 예: 2025-10-13 10:12:34 +0900
    return new Date(iso.replace(" +0900", "+09:00").replace(" +0000", "+00:00"));
  } catch {
    return new Date(0);
  }
}

// 파일명에서 난이도/문제번호 대충 캐기
function parseMeta(platform, filename) {
  const base = path.basename(filename);

  // 난이도 추출 후보: [Gold III], [level 2], D3 등
  let level = "";
  const bracket = base.match(/\[(.*?)\]/); // 첫 대괄호
  if (bracket) level = bracket[1].trim();

  if (!level) {
    if (/gold|silver|bronze|platinum|diamond|ruby/i.test(base)) {
      const m = base.match(/(bronze|silver|gold|platinum|diamond|ruby)\s*([0-5IiV]*)/i);
      if (m) level = `${m[1]} ${m[2]}`.trim();
    } else if (/level\s*\d/i.test(base)) {
      const m = base.match(/level\s*\d/i);
      if (m) level = m[0];
    } else if (/D[1-5]\b/.test(base)) {
      const m = base.match(/D[1-5]\b/);
      if (m) level = m[0];
    }
  }

  // 문제 ID 후보: 가장 먼저 나오는 3~6자리 숫자
  const idMatch = base.match(/(\d{3,6})/);
  const probId = idMatch ? idMatch[1] : "";

  return { level, probId };
}

function buildProblemLink(platform, probId, repoRelPath) {
  if (probId && LINK_TEMPLATE[platform]) {
    return `[바로가기](${LINK_TEMPLATE[platform](probId)})`;
  }
  // 문제번호 못 찾으면 레포 파일 링크로 대체
  const gh = process.env.GITHUB_REPOSITORY || ""; // e.g., dudxo/Baekjoon_Study
  const ref = process.env.GITHUB_REF_NAME || "master";
  if (gh) {
    return `[repo](${`https://github.com/${gh}/blob/${ref}/${encodeURI(repoRelPath.replace(/\\/g, "/"))}`})`;
  }
  return "[repo](.)";
}

function formatDateKST(date) {
  const y = date.getFullYear();
  const m = String(date.getMonth() + 1).padStart(2, "0");
  const d = String(date.getDate()).padStart(2, "0");
  return `${y}-${m}-${d}`;
}

function buildTable(rows) {
  const header = `| 날짜 | 플랫폼 | 문제 | 난이도/태그 | 링크 |
|------|--------|------|-------------|------|`;
  const lines = rows.map((r) =>
    `| ${r.date} | ${r.platform} | ${r.title} | ${r.level || "-"} | ${r.link} |`
  );
  return [header, ...lines].join("\n");
}

function replaceSection(content, startMark, endMark, newSection) {
  const s = content.indexOf(startMark);
  const e = content.indexOf(endMark);
  if (s === -1 || e === -1 || e < s) throw new Error("README 마커가 올바르지 않습니다.");
  const before = content.slice(0, s + startMark.length);
  const after = content.slice(e);
  return `${before}\n${newSection}\n${after}`;
}

function shorten(title) {
  // 너무 길면 잘라주기
  const max = 70;
  return title.length > max ? title.slice(0, max - 1) + "…" : title;
}

async function main() {
  // GITHUB_REPOSITORY 값이 없을 수 있으니 로컬에서도 동작하도록
  if (!process.env.GITHUB_REPOSITORY) {
    try {
      const remote = run("git config --get remote.origin.url");
      // 형태: https://github.com/user/repo.git
      const m = remote.match(/github\.com[:/](.+?)\.git$/);
      if (m) process.env.GITHUB_REPOSITORY = m[1];
    } catch {}
  }
  // 기본 브랜치 추정
  if (!process.env.GITHUB_REF_NAME) {
    try {
      process.env.GITHUB_REF_NAME = run("git rev-parse --abbrev-ref HEAD");
    } catch {
      process.env.GITHUB_REF_NAME = "master";
    }
  }

  const candidates = [];

  for (const t of TARGETS) {
    const dirAbs = path.resolve(ROOT, t.dir);
    if (!fs.existsSync(dirAbs)) continue;
    const files = listFilesRec(dirAbs);

    for (const f of files) {
      const mtime = safeStat(f);
      const rel = path.relative(ROOT, f);
      const title = shorten(rel.replace(/\\/g, "/"));
      const meta = parseMeta(t.platform, f);
      const link = buildProblemLink(t.platform, meta.probId, rel);

      candidates.push({
        platform: t.platform,
        title: `[${title}](${link.includes("repo](") ? link.match(/$begin:math:text$(.*?)$end:math:text$$/)?.[1] : "#"})`,
        // 위 라인은 표의 "문제" 칸을 repo 링크로 통일 (링크 칸은 플랫폼 링크)
        // 시각적으로는 문제칸=파일경로(클릭 시 레포 파일로), 링크칸=문제 원문 링크
        level: meta.level,
        link,          // 원문 링크 또는 레포 링크
        dateObj: mtime,
        date: formatDateKST(mtime),
      });
    }
  }

  // 최신순 정렬 후 상위 N개
  candidates.sort((a, b) => b.dateObj - a.dateObj);
  const top = candidates.slice(0, RECENT_COUNT);

  const table = buildTable(top);

  const readme = fs.readFileSync(README_PATH, "utf8");
  const next = replaceSection(readme, MARK_START, MARK_END, `\n${table}\n`);
  fs.writeFileSync(README_PATH, next);

  console.log(`[info] Updated README with ${top.length} items.`);
}

main().catch((e) => {
  console.error(e);
  process.exit(1);
});
