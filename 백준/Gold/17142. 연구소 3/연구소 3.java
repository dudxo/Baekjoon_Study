import java.io.*;
import java.util.*;

public class Main {

    static int N, M, air, tmpAir;
    static List<int[]> virus, mixVirus;
    static boolean[] isUsed;
    static boolean[][] visited;
    static Deque<int[]> dq;
    static int[][] map, tmpMap;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    /**
     * 0 - 빈칸, 1 - 벽, 2 - 비활성 바이러스, 3 - 활성 바이러스
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        virus = new ArrayList<>();
        mixVirus = new ArrayList<>();

        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());

        map = new int[N][N];

        int tmp = 0;
        for(int i = 0; i < N; i++) {
            str = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                tmp = Integer.parseInt(str.nextToken());
                if(tmp == 2) {
                    virus.add(new int[] {i, j});
                }
                if(tmp == 0) {
                    air += 1;
                }
                map[i][j] = tmp;
            }
        }
        int result = Integer.MAX_VALUE;
        if(air == 0) {
            result = 0;
        } else {
            isUsed = new boolean[virus.size()];
            int[] arr = new int[0];
            backTraking(0, arr);

            int st = 0;
            int time = 0;
            while (true) {
                if (st == mixVirus.size())
                    break;
                visited = new boolean[N][N];

                tmpAir = air;
                copyMap();
                activVirus(st);

                time = sol();
                if (time != -1) {
                    result = Math.min(result, time);
                }

                st++;
            }
        }

        bw.write(result == Integer.MAX_VALUE ? "-1" : String.valueOf(result));
        bw.flush();
        br.close();
        bw.close();
    }

    private static void backTraking(int k, int[] arr) {
        if(k == M) {
            int[] tmp = new int[M];
            for(int i = 0; i < M; i++) {
                tmp[i] = arr[i];
            }
            mixVirus.add(tmp);
            return;
        }

        for(int i = 0; i < virus.size(); i++) {
            if(!isUsed[i]) {
                if(k == 0) arr = new int[M];

                int[] now = virus.get(i);


                arr[k] = (now[0] * 100) + now[1];
                if(k != 0 && arr[k-1] > arr[k]) continue;
                isUsed[i] = true;
                backTraking(k+1, arr);
                isUsed[i] = false;
            }
        }
    }

    private static int sol() {
        int time = 0;

        while(true) {
            int size = dq.size();
            if(tmpAir == 0) break;
            while(size-- > 0) {
                int[] now = dq.poll();

                for(int k = 0; k < 4; k++) {
                    int nx = now[0] + dx[k];
                    int ny = now[1] + dy[k];

                    if(nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny]) continue;

                    if(tmpMap[nx][ny] == 0) {
                        tmpAir -= 1;
                        visited[nx][ny] = true;
                        dq.add(new int[] {nx, ny});
                    }

                    if(tmpMap[nx][ny] == 2) {
                        visited[nx][ny] = true;
                        dq.add(new int[] {nx, ny});
                    }
                }
            }

            if(dq.size() == 0) break;

            time += 1;
        }

        return tmpAir == 0 ? time : -1;
    }

    // private static void activVirus(int st) {
    //     dq = new ArrayDeque<>();
    //     for(int i = 0; i < M; i++) {
    //         int[] now = virus.get(st);
    //         int x = now[0];
    //         int y = now[1];
    //         tmpMap[x][y] = 3; // M개 바이러스 활성화
    //
    //         dq.add(new int[] {x, y});  // 활성화 바이러스 위치 저장
    //         visited[x][y] = true;
    //         st++;
    //     }
    // }
    private static void activVirus(int st) {
        dq = new ArrayDeque<>();
        int[] now = mixVirus.get(st);
        for(int i = 0; i < M; i++) {
            int num = now[i];
            int x = num / 100;
            int y = num % 100;

            dq.add(new int[] {x, y});
        }
    }

    private static void copyMap() {
        tmpMap = new int[N][N];
        for(int i = 0; i < N; i++) {
            tmpMap[i] = map[i];
        }
    }

}