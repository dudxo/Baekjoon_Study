import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N, M, H, days, greenTomato;
    static int[] dx = {0, 0, 1, 0, -1, 0};
    static int[] dy = {0, 0, 0, 1, 0, -1};
    static int[] dz = {1, -1, 0, 0, 0, 0};
    static int[][][] box, arr;
    static boolean[][][] visited;
    static Queue<int[]> q = new LinkedList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        H = sc.nextInt();


        box = new int[H][N][M];
        arr = new int[H][N][M];
        visited = new boolean[H][N][M];
        for(int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int tomato = sc.nextInt();
                    if(tomato == 0) {
                        greenTomato += 1;
                    }
                    if(tomato == 1) {
                        q.add(new int[] {k, i, j});
                    }
                    box[k][i][j] = tomato;
                }
            }
        }

        BFS();
        if(greenTomato == 0) {
            System.out.println(days);
        } else {
            System.out.println(-1);
        }
    }

    private static void BFS() {
        while(greenTomato > 0 && !q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] now = q.poll();
                for(int k = 0; k < 6; k++) {
                    int nz = now[0] + dz[k];
                    int nx = now[1] + dx[k];
                    int ny = now[2] + dy[k];

                    if(nx < 0 || nx >= N || ny < 0 || ny >= M || nz < 0 || nz>= H) {
                        continue;
                    }
                    if(box[nz][nx][ny] == -1 || box[nz][nx][ny] == 1) {
                        continue;
                    }

                    greenTomato--;
                    box[nz][nx][ny] = 1;
                    q.add(new int[] {nz, nx, ny});
                }
            }
            days++;
        }
    }
}