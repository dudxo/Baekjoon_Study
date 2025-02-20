import java.io.*;
import java.util.*;

public class Main {

    static int N, K;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer str;

        str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        K = Integer.parseInt(str.nextToken());

        dp = new int[K+1][N+1];

        for(int i = 0; i <= K; i++) {
            dp[i][0] = 1;
        }

        for(int i = 1; i <= K; i++) {
            for(int j = 1; j <= N; j++) {
                dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1_000_000_000;
            }
        }

        sb.append(dp[K][N] % 1_000_000_000);


        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}