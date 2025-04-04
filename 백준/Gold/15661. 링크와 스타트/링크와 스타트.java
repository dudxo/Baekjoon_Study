import java.io.*;
import java.util.*;

public class Main {

    static int N, result;
    static int[][] map;
    static boolean[] isUsed;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str;

        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        isUsed = new boolean[N+1];

        for(int i = 1; i <= N; i++) {
            str = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(str.nextToken());
            }
        }

        result = Integer.MAX_VALUE;

        for(int i = 1; i < ((1 << N)-1)/2; i++) {
            int team1 = 0;
            int team2 = 0;

            for(int p = 0; p < N; p++) {
                int bp = (i>>p) & 1;
                for(int q = p+1; q < N; q++) {
                    int bq = (i>>q) & 1;

                    int np = p+1;
                    int nq = q+1;

                    if((bp ^ bq) == 0) {
                        if(bq == 1) team1 += map[np][nq] + map[nq][np];
                        else team2 += map[np][nq] + map[nq][np];
                    }
                }
            }

            result = Math.min(result, Math.abs(team1 - team2));
        }

        bw.write(String.valueOf(result));
        bw.flush();
    }

}