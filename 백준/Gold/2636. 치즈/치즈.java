import java.io.*;
import java.util.*;

public class Main {

    static int N, M, cheese, last, time;
    static int[][] arr;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());
        arr = new int[N][M];
        cheese = 0;

        for(int i = 0; i < N; i++) {
            str = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(str.nextToken());
                if(arr[i][j] == 1) {
                    cheese += 1;
                }
            }
        }

        last = 0;
        time = 0;
        while(cheese != 0) {
            last = cheese;
            time += 1;
            visited = new boolean[N][M];
            BFS();
        }


        sb.append(time).append("\n").append(last);
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    private static void BFS() {
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[] {0, 0});
        visited[0][0] = true;

        while(!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];

            for(int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny]) {
                    continue;
                }

                if(arr[nx][ny] == 0) {
                    q.add(new int[] {nx, ny});
                } else {
                    cheese -= 1;
                    arr[nx][ny] = 0;
                }
                visited[nx][ny] = true;
            }
        }
    }
}