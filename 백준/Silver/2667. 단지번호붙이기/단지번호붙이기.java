
import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] map;
    static boolean[][] visited;
    static ArrayList<Integer> answers = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        /**
         * 1. 지도 초기화
         * 2. 반복문 돌면서 방문 여부와 집 존재 여부 체크
         * 2-1. 두 조건 만족 시 너비 우선 탐색
         * 2-2. 너비 우선 탐색 완료 시 단지 내 아파트 수 return
         * 2-3. 총 단지 리스트에 삽입
         * 3. 리스트 오름차순 정렬
         * 4. 출력
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            char[] chArr = br.readLine().toCharArray();
            for(int j = 0; j < N; j++) {
                map[i][j] = chArr[j] - '0';
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(isNotVisitApartment(i, j)) {
                    answers.add(BFS(i, j));
                }
            }
        }

        Collections.sort(answers);

        print(sb);

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();

    }

    private static void print(StringBuilder sb) {
        sb.append(answers.size()).append("\n");

        for(int i : answers) {
            sb.append(i).append("\n");
        }
    }

    private static int BFS(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {i, j});
        visited[i][j] = true;

        int count = 1;

        while(!q.isEmpty()) {
            int[] now = q.poll();

            for(int k = 0; k < 4; k++) {
                int nx = now[0] + dx[k];
                int ny = now[1] + dy[k];

                if(nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny]) {
                    continue;
                }

                if(map[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    q.add(new int[] {nx, ny});
                    count += 1;
                }
            }
        }

        return count;
    }

    private static boolean isNotVisitApartment(int i, int j) {
        return !visited[i][j] && map[i][j] == 1;
    }


}