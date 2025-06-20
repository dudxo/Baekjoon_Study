import java.util.*;

class Solution {
    
    private static int[] dx = {0, -1, 0, 1};
    private static int[] dy = {-1, 0, 1, 0};
    private static String[][] sArr;
    private static int n, m;
    
    public int solution(String[] storage, String[] requests) {
        sArr = new String[storage.length][storage[0].length()];
        
        n = storage.length;
        m = storage[0].length();
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) { 
                sArr[i][j] = String.valueOf(storage[i].charAt(j));
            }
        }
        
        int cnt = 0;
        for(String str : requests) {
            System.out.printf("======%s=======\n", str);
            if(str.length() == 2) {
                str = str.substring(0, 1);
                
                for(int i = 0; i < n; i++) { 
                    for(int j = 0; j < m; j++) {
                        if(str.equals(sArr[i][j])) {
                            System.out.printf("[%d,%d] 제거", i, j);
                            sArr[i][j] = "0";
                            cnt++;
                        }
                    }
                }
            } 
            else {
                ArrayList<int[]> memory = new ArrayList<>();
                for(int i = 0; i < n; i++) { 
                    for(int j = 0; j < m; j++) {
                        if(str.equals(sArr[i][j]) && dfs(i, j)) {
                            memory.add(new int[] {i, j});
                        }
                    }
                }
                
                
                for(int[] arr : memory) {
                    System.out.printf("[%d,%d] 제거", arr[0], arr[1]);
                    sArr[arr[0]][arr[1]] = "0";
                    cnt++;
                }
            }
            System.out.println("===================\n");
        }
        
        System.out.printf("cnt = %d", cnt);
        int answer = (n*m) - cnt;
        
        return answer;
    }
    
    private static boolean dfs(int i , int j) {
        for(int k = 0; k < 4; k++) {
            int nx = dx[k] + i;
            int ny = dy[k] + j;
            
            if(nx < 0 || ny < 0 || nx >= n || ny >= m) return true;
            
            if("0".equals(sArr[nx][ny])) {
                boolean result = dfs(nx, ny);
                if(result) return true;
            }
        }
        
        return false;
    }
}