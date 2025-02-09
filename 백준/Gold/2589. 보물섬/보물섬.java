import java.io.*;
import java.util.*;

public class Main {

    static int N, M, result;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());

        map = new int[N][M];
        result = 0;

        for(int i = 0; i < N; i++) {
            String cmd = br.readLine();
            for(int j = 0; j < M; j++) {
                if('L' == cmd.charAt(j)) {  // 육지 1로 초기화
                    map[i][j] = 1;
                }
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 1) {
                    result = Math.max(BFS(i, j), result);
                }
            }
        }

        sb.append(result);

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    private static int BFS(int i, int j) {
        visited = new boolean[N][M];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {i, j, 0});
        visited[i][j] = true;
        int maxDistance = 0;

        while(!q.isEmpty()) {
            int[] now = q.poll();

            maxDistance = Math.max(maxDistance, now[2]);

            for(int k = 0; k < 4; k++) {
                int nx = now[0] + dx[k];
                int ny = now[1] + dy[k];
                int nd = now[2] + 1;

                if(nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny]) {
                    continue;
                }

                if(map[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    q.add(new int[] {nx, ny, nd});
                }
            }
        }

        return maxDistance;
    }

}