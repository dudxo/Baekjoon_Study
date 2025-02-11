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
        dp[0] = 0;
        dp[1] = 0;
        sb.append(solve(N));

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    private static int solve(int n) {
        if(dp[n] == null) {
            if(n % 6 == 0) {
                dp[n] = Math.min(solve(n/3), Math.min(solve(n/2), solve(n-1))) + 1;
            }
            else if (n % 3 == 0) {
                dp[n] = Math.min(solve(n / 3), solve(n - 1)) + 1;
            } else if (n % 2 == 0) {
                dp[n] = Math.min(solve(n / 2), solve(n - 1)) + 1;
            } else {
                dp[n] = solve(n-1) + 1;
            }
        }

        return dp[n];
    }

}