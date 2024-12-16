import java.util.Scanner;

public class Main {

    static int t, n, k;
    static int[] grape;
    static Integer[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        grape = new int[t+1];
        dp = new Integer[t+1];
        for(int i = 1; i <= t; i++) {
            grape[i] = sc.nextInt();
        }
        dp[0] = 0;
        System.out.print(maxWine());
    }

    private static int maxWine() {
        for(int i = 1; i <= t; i++) {
            if(i == 1) {
                dp[i] = grape[1];
            }
            else if(i == 2) {
                dp[i] = grape[i] + grape[i-1];
            } else{
                dp[i] = Math.max(dp[i-1], Math.max(dp[i-2]+grape[i], dp[i-3] + grape[i-1] + grape[i]));
            }
        }
        return dp[t];
    }
}