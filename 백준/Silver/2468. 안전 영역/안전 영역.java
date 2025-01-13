import java.io.*;
import java.util.*;

public class Main {

    static int N, result;
    static int[][] arr;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        result = 0;

        int high = 0;
        for(int i = 0; i < N; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(str.nextToken());
                high = Math.max(high, arr[i][j]);
            }
        }

        while(high-- >= 1) {
            int answer = 0;
            visited = new boolean[N][N];
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(high < arr[i][j] && !visited[i][j]) {
                        answer += BFS(i, j, high);
                    }
                }
            }
            result = Math.max(result, answer);
        }

        sb.append(result);
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    private static int BFS(int i, int j, int high) {
        int count = 0;
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[] {i, j});
        visited[i][j] = true;

        while(!q.isEmpty()) {
            count = 1;
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];

            for(int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if(nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) {
                    continue;
                }

                if(high >= arr[nx][ny]) {
                    continue;
                }

                q.add(new int[] {nx, ny});
                visited[nx][ny] = true;
            }
        }
        return count;
    }
}