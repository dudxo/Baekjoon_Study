import java.util.*;

class Solution {
    
    static int[][] map;
    static int[][] dp;
    static int[] dx = {0, 1};
    static int[] dy = {1, 0};
    static int N, M, min, cnt;
    static final int MOD = 1_000_000_007;
    
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        N = n;
        M = m;        
        min = Integer.MAX_VALUE;
        cnt = 0;
        
        map = new int[N+1][M+1];
        for(int[] p : puddles) {
            map[p[1]][p[0]] = -1;
        }
        
        dp = new int[N+1][M+1];
        for(int i = 0; i <= N; i++) {
            for(int j = 0; j <= M; j++) {
                dp[i][j] = -1;
            }
        }
        
        sol(1, 1, 0);
        
        // for(int i = 0; i <= N; i++) {
        //     for(int j = 0; j <= M; j++) {
        //         System.out.printf("dp[%d][%d] = %d\n", i, j, dp[i][j]);
        //     }
        // }

        // dfs(1, 1, 0);
        answer = dp[1][1];
        
        return answer ;
    }
    
    
    private static int sol(int x, int y, int dist) {
        if(x > N || y > M || (map[x][y] == -1)) {
            return 0;
        }
        
        if(x == N && y == M) {
            if(min < dist) return 0;
            min = dist;
            return 1;
        }
        
        if(dp[x][y] != -1) {
            return dp[x][y];
        }
        
        // 아래로 가기, 우로 가기
        return dp[x][y] = (sol(x+1, y, dist+1) + sol(x, y+1, dist+1)) % MOD;
    }
}