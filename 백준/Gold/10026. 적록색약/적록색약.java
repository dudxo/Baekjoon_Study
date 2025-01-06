import java.io.*;
import java.util.*;

public class Main {

    static int N, normal, color;
    static Character[][] arr;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] n_visited;
    static boolean[][] c_visited;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new Character[N][N];
        n_visited = new boolean[N][N];
        c_visited = new boolean[N][N];

        normal = 0;
        color = 0;

        for(int i = 0; i < N; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            String RGB = str.nextToken();
            for(int j = 0; j < N; j++) {
                arr[i][j] = RGB.charAt(j);
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!n_visited[i][j]) {
                    BFS(i, j, true);
                    normal += 1;
                }
                if(!c_visited[i][j]) {
                    BFS(i, j, false);
                    color += 1;
                }
            }
        }
        sb.append(normal).append(" ").append(color);

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    private static void BFS(int i, int j, boolean check) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {i, j});

        if(check) {
            n_visited[i][j] = true;
        } else {
            c_visited[i][j] = true;
        }

        while(!q.isEmpty()) {
            int[] now = q.poll();
            if(check) {
                n_visited[now[0]][now[1]] = true;
            } else {
                c_visited[now[0]][now[1]] = true;
            }

            for(int k = 0; k < 4; k++) {
                int nx = now[0] + dx[k];
                int ny = now[1] + dy[k];


                if(nx < 0 || nx >= N || ny < 0 || ny >= N) {
                    continue;
                }

                if(check && n_visited[nx][ny]) {
                    continue;
                }

                if(!check && c_visited[nx][ny]) {
                    continue;
                }

                if(check) {
                    if (arr[now[0]][now[1]] == arr[nx][ny]) {
                        q.add(new int[] {nx, ny});
                        n_visited[nx][ny] = true;
                    }
                }
                if(!check){
                    if(arr[now[0]][now[1]] == 'R' || arr[now[0]][now[1]] == 'G') {
                        if(arr[nx][ny] == 'R' || arr[nx][ny] == 'G') {
                            q.add(new int[] {nx, ny});
                            c_visited[nx][ny] = true;
                        }
                    }
                    else if(arr[now[0]][now[1]] == arr[nx][ny]) {
                        q.add(new int[] {nx, ny});
                        c_visited[nx][ny] = true;
                    }
                }
            }
        }
    }
}