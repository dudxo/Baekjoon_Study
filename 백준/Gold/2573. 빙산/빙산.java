import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int N, M, year;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] iceberg;
    static Queue<int[]> q = new LinkedList<>();
    static Queue<int[]> d = new LinkedList<>();
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        iceberg = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                int ice = sc.nextInt();
                if(ice != 0 ) {
                    q.add(new int[] {i, j});
                }
                iceberg[i][j] = ice;
            }
        }
        BFS();

    }

    private static void BFS() {
        while(!q.isEmpty()) {
            int size = q.size();
            if(check() >= 2) {
                System.out.println(year);
                return;
            }

            for(int i = 0; i < size; i++) {
                int[] now = q.poll();
                int sea = 0;
                for(int k = 0; k < 4; k++) {
                    int nx = now[0] + dx[k];
                    int ny = now[1] + dy[k];

                    if(nx < 0 || nx >= N || ny < 0 || ny >= M) {
                        continue;
                    }

                    if(iceberg[nx][ny] == 0) {
                        sea += 1;
                    }
                }
                d.add(new int[] {now[0], now[1], sea});
            }
            down();
            year++;
        }
        System.out.println(0);
    }

    private static int check() {
        visited = new boolean[N][M];
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && iceberg[i][j] > 0) {
                    dfs(i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private static void dfs(int i, int j) {
        visited[i][j] = true;
        for(int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];
            if(nx >= 0 && nx < N && ny >= 0 && ny < M) {
                if(!visited[nx][ny] && iceberg[nx][ny] != 0 ) {
                    dfs(nx, ny);
                }
            }
        }
    }

    private static void down() {
        while(!d.isEmpty()) {
            int[] ice = d.poll();
            int nx = ice[0];
            int ny = ice[1];
            int sea = ice[2];

            if(sea == 0) {
                q.add(new int[] {nx, ny});
                continue;
            }

            iceberg[nx][ny] -= sea;
            if(iceberg[nx][ny] <= 0) {
                iceberg[nx][ny] = 0;
            } else {
                q.add(new int[] {nx, ny});
            }
        }
    }
}