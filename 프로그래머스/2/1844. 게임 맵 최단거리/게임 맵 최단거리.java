import java.util.*;

class Solution {
    
    static int x, y;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] dist;
    static boolean[][] visited;
    
    public int solution(int[][] maps) {
        int answer = 0;
        
        x = maps.length;
        y = maps[0].length;
        
        visited = new boolean[x][y];
        dist = new int[x][y];
        dist[0][0] = 1;
        
        return sol(maps);
    }
    
    private static int sol(int[][] maps) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {0, 0});
        visited[0][0] = true;
        
        while(!q.isEmpty()) {
            int[] now = q.poll();
            
            for(int k = 0; k < 4; k++) {
                int nx = now[0] + dx[k];
                int ny = now[1] + dy[k];
                
                if(nx < 0 || ny < 0 || nx >= x || ny >= y || maps[nx][ny] == 0 || visited[nx][ny]) {
                    continue;
                }
                
                visited[nx][ny] = true;
                q.add(new int[] {nx, ny});
                
                dist[nx][ny] = dist[now[0]][now[1]] + 1;
            }
        }
        
        return dist[x-1][y-1] == 0 ? -1 : dist[x-1][y-1];
    }
}