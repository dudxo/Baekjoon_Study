import java.io.*;
import java.util.*;

public class Main {

    static int N, L, R, day;
    static boolean flag;
    static int[] dx = new int[] {0, 1, 0, -1};
    static int[] dy = new int[] {1, 0, -1, 0};
    static int[][] countries;
    static boolean[][] visited, isUsed;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer str;

        str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        L = Integer.parseInt(str.nextToken());
        R = Integer.parseInt(str.nextToken());

        countries = new int[N][N];

        for(int i = 0; i < N; i++) {
            str = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                countries[i][j] = Integer.parseInt(str.nextToken());
            }
        }

        day = 0;

        while(true) {
            visited = new boolean[N][N];
            flag = false;

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    List<int[]> aso = new ArrayList<>();
                    if(!visited[i][j]) {
                        int total = dfs(i, j, aso);

                        if(aso.size() >= 2) {
                            flag = true;
                            int result = total / aso.size();
                            for(int[] iArr : aso) {
                                countries[iArr[0]][iArr[1]] = result;
                            }
                        }
                    }
                }
            }

            if(!flag) {
                break;
            }

            day += 1;
        }

        sb.append(day);

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    private static int dfs(int i, int j, List<int[]> aso) {
        visited[i][j] = true;
        aso.add(new int[] {i, j});
        int total = countries[i][j];

        for(int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];

            if(nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny]) {
                continue;
            }

            int psub = Math.abs(countries[i][j] - countries[nx][ny]);

            if(psub < L || psub > R) {
                continue;
            }

            total += dfs(nx, ny, aso);
        }
        return total;
    }
}