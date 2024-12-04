
import java.util.Scanner;

public class Main {

    static Integer[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();

        dp = new Integer[x+1];
        dp[0] = dp[1] = 0;
        System.out.println(abc(x));
    }

    private static int abc(int x) {
        if(dp[x] == null) {
            if(x % 6 == 0) {
                dp[x] = Math.min(abc(x-1), Math.min(abc(x/2), abc(x/3))) + 1;
            }
            else if(x % 3 == 0) {
                dp[x] = Math.min(abc(x/3), abc(x-1)) + 1;
            }
            else if(x % 2 == 0 ) {
                dp[x] = Math.min(abc(x/2), abc(x-1)) + 1;
            }
            else {
                dp[x] = abc(x-1) + 1;
            }
        }
        return dp[x];
    }
}