import java.util.Scanner;

public class Main {

    static int t, n, k;
    static Integer[][] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        while(t > 0) {
            k = sc.nextInt();
            n = sc.nextInt();
            dp = new Integer[k+1][n+1];
            for(int i = 1; i <= n; i++) {
                dp[0][i] = i;
            }
            int result = dp(k,n);
            sb.append(result).append("\n");
            t--;
        }
        System.out.println(sb);
    }

    private static int dp(int k, int n) {
        if(n == 1) {
            return dp[0][1];
        }
        
        if(dp[k][n] == null) {
            dp[k][n] = 0;
            dp[k][n] = dp(k, n-1) + dp(k-1, n);
        }

        return dp[k][n];
    }
}