import java.io.*;
import java.util.*;

public class Main {

    static int N, K, L, cur;
    static int[][] map;
    static Queue<Node> cmds;
    static Queue<int[]> snake;

    static class Node {
        int ms;
        char cmd;

        Node(int ms, char cmd) {
            this.ms = ms;
            this.cmd = cmd;
        }
    }

    // cur(상하좌우 기준) 1 -1 2 -2
    // 왼쪽 - L, 오른쪽 - D 방향으로 90도 회전
    // => L-반시계, D-시계
    // map[x][y] == 1 -> 사과, 2 -> 뱀
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer str;

        cur = -2;
        cmds = new ArrayDeque<>();
        snake = new ArrayDeque<>();

        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        map[1][1] = 2;
        snake.add(new int[] {1, 1});

        K = Integer.parseInt(br.readLine());
        int x = 0, y = 0;
        for(int i = 0; i < K; i++) {
            str = new StringTokenizer(br.readLine());
            x = Integer.parseInt(str.nextToken());
            y = Integer.parseInt(str.nextToken());

            map[x][y] = 1;
        }

        L = Integer.parseInt(br.readLine());

        int ms = 0;
        char cmd = ' ';
        for(int i = 0; i < L; i++) {
            str = new StringTokenizer(br.readLine());
            ms = Integer.parseInt(str.nextToken());
            cmd = str.nextToken().charAt(0);

            cmds.add(new Node(ms, cmd));
        }

        sb.append(sol(1, 1));

        bw.write(sb.toString());
        bw.flush();
    }

    private static int sol(int st, int ed) {
        int time = 1;
        while(true) {

            check(time);
            int[] next = go(st, ed);
            if(next[0] == -1 && next[1] == -1) break; // 벽 또는 몸과 부딪힘

            int nx = next[0];
            int ny = next[1];

            if(map[nx][ny] != 1) {
                // 꼬리 줄이기
                int[] tail = snake.remove();
                map[tail[0]][tail[1]] = 0;
            }
            map[nx][ny] = 2;
            snake.add(new int[] {nx, ny});
            st = nx;
            ed = ny;

            time++;
        }

        return time;
    }

    private static void check(int time) {
        if(cmds.isEmpty()) return;
        Node nc = cmds.peek();
        if(time > nc.ms) {
            //상하좌우
            switch (cur) {
                case 1:
                    cur = nc.cmd == 'L' ? 2 : -2;
                    break;
                case -1:
                    cur = nc.cmd == 'L' ? -2 : 2;
                    break;
                case 2:
                    cur = nc.cmd == 'L' ? -1 : 1;
                    break;
                case -2:
                    cur = nc.cmd == 'L' ? 1 : -1;
                    break;
            }
            cmds.remove();
        }
    }

    private static int[] go(int st, int ed) {
        // 순서대로 상하좌우
        switch (cur) {
            case 1:
                if(st-1 <= 0 || map[st-1][ed] == 2) return new int[]{-1, -1};
                st -= 1;
                break;
            case -1:
                if(st+1 > N || map[st+1][ed] == 2) return new int[]{-1, -1};
                st += 1;
                break;
            case 2:
                if(ed-1 <= 0 || map[st][ed-1] == 2) return new int[]{-1, -1};
                ed -= 1;
                break;
            case -2:
                if(ed+1 > N || map[st][ed+1] == 2) return new int[]{-1, -1};
                ed += 1;
                break;

        }

        return new int[] {st, ed};
    }

}