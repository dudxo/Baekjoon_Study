import java.io.*;
import java.util.*;

public class Main {

    static int N, now;
    static int[] cards, dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        cards = new int[N+1];
        dp = new int[N+1];
        StringTokenizer str = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            cards[i] = Integer.parseInt(str.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] + cards[j]);
            }
        }

        sb.append(dp[N]);
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}