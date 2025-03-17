import java.io.*;
import java.util.*;

public class Main {

    static int N, M, clean, vision, x, y;
    static int[] dx = new int[] {0, 1, 0, -1};
    static int[] dy = new int[] {1, 0, -1, 0};
    static int[][] map;

    /**
     * -1 청소기 시작 위치, 0 - 청소되지 않은 곳, 1 - 벽, 2 - 청소한 곳
     * 0 - 북, 1 - 동, 2- 남, 3- 서
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());

        map = new int[N][M];
        str = new StringTokenizer(br.readLine());
        x = Integer.parseInt(str.nextToken());
        y = Integer.parseInt(str.nextToken());
        vision = Integer.parseInt(str.nextToken());

        for(int i = 0; i < N; i++) {
            str = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < M; j++) {
                map[i][j] = Integer.parseInt(str.nextToken());
            }
        }

        run();
        bw.write(String.valueOf(clean));

        bw.flush();
        br.close();
        bw.close();
    }

    private static void run() {
        while(true) {

            if(map[x][y] == 0) {
                map[x][y] = 2;
                clean += 1;
            }

            if(bfs(x, y)) {
                while(true) {
                    // 반시계 회전
                    switch (vision) {
                        case 0 :
                            vision = 3;
                            break;
                        case 1 :
                            vision = 0;
                            break;
                        case 2 :
                            vision = 1;
                            break;
                        case 3 :
                            vision = 2;
                            break;
                    }
                    // 청소되지 않은 공간인지 확인
                    boolean flag = false;
                    switch (vision) {
                        case 0 :
                            if(x > 0 && map[x-1][y] == 0) {
                                flag = true;
                                x -= 1;
                            }
                            break;
                        case 1 :
                            if(y < M-1 && map[x][y+1] == 0) {
                                flag = true;
                                y += 1;
                            }
                            break;
                        case 2 :
                            if(x < N-1 && map[x+1][y] == 0) {
                                flag = true;
                                x += 1;
                            }
                            break;
                        case 3 :
                            if(y > 0 && map[x][y-1] == 0) {
                                flag = true;
                                y -= 1;
                            }
                            break;
                    }

                    // 이동했다면 1번으로 돌아간다.
                    if(flag) break;
                }
            } else {
                boolean flag = false;
                switch (vision) {
                    case 0 :
                        if(x < N-1 && map[x+1][y] != 1) {
                            flag = true;
                            x += 1;
                        }
                        break;
                    case 1 :
                        if(y > 0 && map[x][y-1] != 1) {
                            flag = true;
                            y -= 1;
                        }
                        break;
                    case 2 :
                        if(x > 0 && map[x-1][y] != 1) {
                            flag = true;
                            x -= 1;
                        }
                        break;
                    case 3 :
                        if(y < M-1 && map[x][y+1] != 1) {
                            flag = true;
                            y += 1;
                        }
                        break;
                }

                if(!flag) break;
            }
        }
    }

    private static boolean bfs(int x, int y) {
        for(int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if(nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] != 0) continue;

            return true;
        }

        return false;
    }

}