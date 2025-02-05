
import java.io.*;
import java.util.*;

public class Main {

    static int M, N, green_tomato;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] map;
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer str = new StringTokenizer(br.readLine());
        M = Integer.parseInt(str.nextToken());
        N = Integer.parseInt(str.nextToken());

        map = new int[N][M];
        green_tomato = 0;

        for(int i = 0; i < N; i++) {
            str = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                int status = Integer.parseInt(str.nextToken());

                if(status == 1) {
                    q.add(new int[] {i, j});
                }
                if(status == 0) {
                    green_tomato += 1;
                }
                map[i][j] = status;
            }
        }

        if(green_tomato == 0) {
            sb.append("0");
        } else {
            sb.append(BFS());
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();

    }

    private static int BFS() {
        int size = 0;
        int day = 0;

        while(!q.isEmpty()) {
            size = q.size();
            day += 1;

            while(size-- > 0) {
                int[] now = q.poll();

                for(int k = 0; k < 4; k++) {
                    int nx = now[0] + dx[k];
                    int ny = now[1] + dy[k];

                    if(nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] != 0) {
                        continue;
                    }

                    map[nx][ny] = 1;
                    q.add(new int[] {nx, ny});
                    green_tomato -= 1;
                }
            }

            if(green_tomato == 0) {
                break;
            }
        }

        if(green_tomato == 0) {
            return day;
        }

        return -1;
    }
}