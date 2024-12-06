import java.util.Scanner;


public class Main {

    static int n;
    static int[] sequence;
    static Integer[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sequence = new int[n];
        dp = new Integer[n];
        for(int i = 0; i < n; i++) {
            sequence[i] = sc.nextInt();
        }
        sum(0);

        int max = dp[0];
        for(int i : dp) {
            if(i > max) {
                max = i;
            }
        }
        System.out.println(max);
    }

    private static int sum(int i) {
        if(i == n-1) {
            dp[i] = sequence[i];
        }
        if(dp[i] == null) {
            dp[i] = 0;
            if(i < n-1) {
                dp[i] = Math.max(sum(i+1) + sequence[i], sequence[i]);
            }

        }

        return dp[i];
    }
}