import java.util.Scanner;


public class Main {

    static int N, M;
    static int[][] maze;
    static Integer[][] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        maze = new int[N+1][M+1];
        dp = new Integer[N+1][M+1];

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= M; j++) {
                int candy = sc.nextInt();
                maze[i][j] = candy;
            }
        }
        dp[N][M] = maze[N][M];

        System.out.println(DFS(1, 1));
    }

    private static int DFS(int i, int j) {
        if(i == N && j == M){
            return maze[i][j];
        }

        if(dp[i][j] == null) {
            dp[i][j] = 0;
            if(i < N && j < M) {
                dp[i][j] = Math.max(DFS(i+1, j), Math.max(DFS(i, j+1), DFS(i+1, j+1))) + maze[i][j];
            }
            else if(i >= N && j < M) {
                dp[i][j] = DFS(i, j+1) + maze[i][j];
            } else if(i < N && j >= M) {
                dp[i][j] = DFS(i+1, j) + maze[i][j];
            }
        }
        return dp[i][j];
    }
}