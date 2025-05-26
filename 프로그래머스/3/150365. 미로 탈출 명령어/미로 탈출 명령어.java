import java.util.*;

class Solution {
    
    static int gn, gm, gr, gc, gk;
    static int[][] map;
    static String[][][] dp;
    static int[] dx = new int[] {1, 0, -1, 0};
    static int[] dy = new int[] {0, 1, 0, -1};
    static List<String> ans;
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        map = new int[n+1][m+1];
        ans = new ArrayList<>();
        gn = n; gm = m; gr = r; gc = c; gk = k;
        
        dp = new String[n+1][m+1][k+1];       
        
        String answer = sol(x, y, 0, "");
        
        if(answer.equals("zzzzzzzz")) answer = "impossible";
        
        return answer;
    }
    
    
    /*DP 풀이 중..*/
    private static String sol(int x, int y, int cur, String path) {
        // System.out.printf("[%d,%d] 도착 = {%s}\n", x, y, sb.toString());
        // System.out.printf("[%d,%d] 도착 = {%s}\n", x, y, path);
        if(cur > gk || x < 1 || y < 1 || x > gn || y > gm) {
            // System.out.printf("기준부합!!%s 삭제 예정!!\n", cur, sb.toString());

            return "zzzzzzzz";
        }
        
         if(cur == gk) {
             if(x == gr && y == gc) {
                 // System.out.printf("도착지점 도착!! = {%s}\n", path);
                 return path;
             }
             
             return "zzzzzzzz";
        }
        
        if(dp[x][y][cur] != null) {
            return dp[x][y][cur];
        }
        
        String s = "zzzzzzzz";
        s = compare(s, sol(x+1, y, cur+1, path+"d"));
        s = compare(s, sol(x, y-1, cur+1, path+"l"));
        s = compare(s, sol(x, y+1, cur+1, path+"r"));
        s = compare(s, sol(x-1, y, cur+1, path+"u"));
              
        
        return dp[x][y][cur] = s;
    }
    
    private static String compare(String s1, String s2) {
        if(s1.compareTo(s2) <= 0) {
            return s1;
        }
        
        return s2;
    }
}