import java.io.*;

public class Main {

    static int N;
    static Integer[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        dp = new Integer[N+1];
        dp[0] = 1;
        dp[1] = 1;
        sb.append(solve(N));

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    private static int solve(int n) {
        if(n == 1 || n == 0) {
            return dp[n];
        }

        if(dp[n] == null) {
            dp[n] = (solve(n-1) + solve(n-2)) % 10007 ;
        }

        return dp[n];
    }

}