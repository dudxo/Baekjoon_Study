import java.util.Scanner;


public class Main {

    static int N;
    static int RGB = 3;
    static int RED = 0, GREEN = 1, BLUE = 2;
    static Integer[][] dp;
    static int[][] homes;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        dp = new Integer[N][3];
        homes = new int[N][RGB];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < RGB; j++) {
                homes[i][j] = sc.nextInt();
            }
        }
        dp[0][RED] = homes[0][RED];
        dp[0][GREEN] = homes[0][GREEN];
        dp[0][BLUE] = homes[0][BLUE];
        int red = DP(N-1, RED);
        int green = DP(N-1, GREEN);
        int blue = DP(N-1, BLUE);
        System.out.println(Math.min(red, Math.min(green, blue)));
    }

    private static int DP(int i, int color) {
        if(dp[i][color] == null){
            if(color == RED) {
                dp[i][RED] = Math.min(DP(i-1, GREEN), DP(i-1, BLUE)) + homes[i][RED];
            } else if(color == GREEN) {
                dp[i][GREEN] = Math.min(DP(i-1, RED), DP(i-1, BLUE)) + homes[i][GREEN];
            } else {
                dp[i][BLUE] = Math.min(DP(i-1, RED), DP(i-1, GREEN)) + homes[i][BLUE];
            }
        }

        return dp[i][color];
    }
}