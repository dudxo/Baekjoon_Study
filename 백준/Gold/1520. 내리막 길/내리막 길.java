import java.util.Scanner;

public class Main {

    static int N, M, count;
    static boolean[][] visited;
    static int[][] dp, map;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();

        count = 0;

        dp = new int[M][N];
        map = new int[M][N];
        visited = new boolean[M][N];

        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
                dp[i][j] = -1;
            }
        }


        System.out.println(DFS(0, 0));
    }

    private static int DFS(int i, int j) {
        if(i == M-1 && j == N-1) {
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

            if(map[i][j] > map[x][y]) {
               dp[i][j] += DFS(x, y);
            }
        }

        return dp[i][j];
    }
}