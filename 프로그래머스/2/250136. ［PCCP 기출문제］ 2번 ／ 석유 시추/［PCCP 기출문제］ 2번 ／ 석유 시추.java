import java.util.*;

class Solution {
    
    static int result, N, M;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static Node[][] map;
    
    static class Node {
        int cost;
        int flag;
        
        Node(int cost, int flag) {
            this.cost = cost;
            this.flag = flag;
        }
    }
    
    public int solution(int[][] land) {
        
        N = land.length;
        M = land[0].length;
        
        int answer = 0;
        map = new Node[N][M];
        visited = new boolean[N][M];
        
        // for(int i = 0; i < N; i++) {
        //     Arrays.fill(map[i], new Node(0, -1));
        // }
        
        // bfs 돌면서 석유 덩어리 계산
        int flag = 1;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(land[i][j] == 1 && !visited[i][j]) {
                    init(i, j, flag++, land);
                }   
            }
        }
        
        // 열을 돌면서 석유량 찾기
        for(int j = 0; j < M; j++) {
            int sum = 0;
            Set<Integer> set = new HashSet<>();
            for(int i = 0; i < N; i++) {
                Node now = map[i][j];
                
                if(now != null && !set.contains(now.flag)) {
                    set.add(now.flag);
                    //list.add(now.flag);
                    sum += now.cost;
                }    
            }
        
            
            answer = Math.max(answer, sum);
        }
        
        return answer;
    }
    
    private static void init(int x, int y, int flag, int[][] land) {
        Queue<int[]> q = new ArrayDeque<>();
        Queue<int[]> tmp = new ArrayDeque<>();
        q.add(new int[] {x, y});
        tmp.add(new int[] {x, y});
        
        visited[x][y] = true;
        int count = 1;
        
        while(!q.isEmpty()) {
            int[] now = q.poll();
            
            for(int k = 0; k < 4; k++) {
                int nx = now[0] + dx[k];
                int ny = now[1] + dy[k];
                
                if(nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny]) {
                    continue;
                }
                
                if(land[nx][ny] == 1) {
                    q.add(new int[] {nx, ny});
                    tmp.add(new int[] {nx, ny});
                    visited[nx][ny] = true;
                    count += 1;
                }
            }
        }
            
        while(!tmp.isEmpty()) {
            int[] now = tmp.poll();
            map[now[0]][now[1]] = new Node(count, flag);
        }
    }
}