import java.util.*;

class Solution {
    
    static int INF = Integer.MAX_VALUE;
    static char[][] map;
    static int[][] record;
    static int[][] dist;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    
    public int solution(String[] maps) {
        int answer = 0;
        
        map = new char[maps.length][maps[0].length()];
        record = new int[3][2];
        int index = 0;
        
        for(int i = 0; i < maps.length; i++) {
            map[i] = maps[i].toCharArray();
        
            if(maps[i].contains("S")) {
                index = maps[i].indexOf("S");
                record[0] = new int[] {i, index};
            }
            
            if(maps[i].contains("L")) {
                index = maps[i].indexOf("L");
                record[1] = new int[] {i, index};
            }
            
            if(maps[i].contains("E")) {
                index = maps[i].indexOf("E");
                record[2] = new int[] {i, index};
            }
        }
        
        // START -> LEVER
        answer = sol(record[0], record[1]);
        if(answer == -1) return -1;
                
        // LEVER -> END
        int tmp = sol(record[1], record[2]);
        if(tmp == -1) return -1;
        answer += tmp;
        
        return answer;
    }
    
    private static int sol(int[] s, int[] e) {
        int s1, s2;
        s1 = map.length;
        s2 = map[0].length;
        
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        visited = new boolean[s1][s2];
        dist = new int[s1][s2];
        
        for(int i = 0; i < s1; i++) {
            for(int j = 0; j < s2; j++) {
                dist[i][j] = INF;
            }
        }
        
        dq.add(s);
        visited[s[0]][s[1]] = true;
        dist[s[0]][s[1]] = 0;
        
        while(!dq.isEmpty()) {
            int[] now = dq.poll();
            
            if(now[0] == e[0] && now[1] == e[1]) {
                break;
            }
            
            for(int k = 0; k < 4; k++) {
                int nx = now[0] + dx[k];
                int ny = now[1] + dy[k];
                
                if(nx < 0 || ny < 0 || nx >= s1 || ny >= s2 ||
                   visited[nx][ny] || map[nx][ny] == 'X') {
                    continue;
                }
                
                dq.add(new int[] {nx, ny});
                visited[nx][ny] = true;
                if(dist[nx][ny] >= dist[now[0]][now[1]] + 1) {
                    dist[nx][ny] = dist[now[0]][now[1]] + 1;
                }
            }
        }
        
        return dist[e[0]][e[1]] == INF ? -1 : dist[e[0]][e[1]];
    }
}