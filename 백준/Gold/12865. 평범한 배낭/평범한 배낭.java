import java.io.*;
import java.util.*;

public class Main {

    static int N, K;
    static int[][] dp;
    static Node[] arr;
    static class Node {
        int w;
        int v;

        Node(int w, int v) {
            this.w = w;
            this.v = v;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        K = Integer.parseInt(str.nextToken());

        dp = new int[N+1][K+1];
        arr = new Node[N+1];

        for(int i = 1; i<= N; i++) {
            str = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(str.nextToken());
            int v = Integer.parseInt(str.nextToken());

            arr[i] = new Node(w, v);
        }

        Arrays.fill(dp[0], 0);
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= K; j++) {
                if(j - arr[i].w >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i-1][j - arr[i].w] + arr[i].v);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        sb.append(dp[N][K]);

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }


}