
import java.io.*;
import java.util.*;

public class Main {

    static int T, M, N, K, answer;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] map;
    static boolean[][] visited;
    static ArrayList<int[]> bachu = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer str;

        T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            answer = 0;

            str = new StringTokenizer(br.readLine());
            N = Integer.parseInt(str.nextToken());
            M = Integer.parseInt(str.nextToken());
            K = Integer.parseInt(str.nextToken());

            map = new int[N][M];
            visited = new boolean[N][M];
            bachu = new ArrayList<>();

            for(int i = 0; i < K; i++) {
                str = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(str.nextToken());
                int y = Integer.parseInt(str.nextToken());

                map[x][y] = 1;
                bachu.add(new int[] {x, y});
            }

            for(int[] iArr : bachu) {
                if(!visited[iArr[0]][iArr[1]]) {
                    BFS(iArr[0], iArr[1]);
                    answer += 1;
                }
            }

            sb.append(answer).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();

    }

    private static void BFS(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {i, j});
        visited[i][j] = true;

        while(!q.isEmpty()) {
            int[] now = q.poll();

            for(int k = 0; k < 4; k++) {
                int nx = now[0] + dx[k];
                int ny = now[1] + dy[k];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny] || map[nx][ny] == 0) {
                    continue;
                }

                visited[nx][ny] = true;
                q.add(new int[] {nx, ny});
            }

        }
    }

}