import java.util.Scanner;

public class Main {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int N, M;
    static int[][] map;
    static int[][] dp;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        sc.nextLine();

        map = new int[M][N];
        dp = new int[M][N];

        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
                dp[i][j] = -1;
            }
        }
        System.out.print(DFS(0, 0));
    }



    private static int DFS(int i, int j) {
       if(i == M-1 && j ==N-1) {
           return 1;
       }

       if(dp[i][j] != -1) {
           return dp[i][j];
       }

       dp[i][j] = 0;

       for(int k = 0; k < 4; k++) {
           int x = i + dx[k];
           int y = j + dy[k];

           if(x < 0 || y < 0 || x >= M || y >= N) {
               continue;
           }

           int next = map[x][y];
           if(map[i][j] > next) {
               dp[i][j] += DFS(x, y);
           }
       }
        return dp[i][j];
    }
}