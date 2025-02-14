import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        dp = new int[N+1];

        StringTokenizer str = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(str.nextToken());
        }

        for(int i = 1; i <= N; i++) {
            dp[i] = 1;      // 최소 1개 수열

            for(int j = 1; j < i; j++) {        // 현재 값보다 앞에 있는 이전 수열 탐색
                // 이전 수열을 이루고 있는(무엇인지 몰라서 전부 탐색) 값보다 크고 이전 수열보다 클 때
                if(arr[j] < arr[i] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        sb.append(Arrays.stream(dp).max().getAsInt());

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

}