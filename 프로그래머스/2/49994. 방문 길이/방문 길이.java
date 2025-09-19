import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        
        char[] cmd = dirs.toCharArray();
        
        Map<Character, int[]> map = new HashMap<>();
        map.put('U', new int[] {1, 0});
        map.put('D', new int[] {-1, 0});
        map.put('L', new int[] {0, -1});
        map.put('R', new int[] {0, 1});
        
        Set<String> set = new HashSet<>();     
                
        int x = 0, y = 0;
        for(char c : cmd) {
            int[] now = map.get(c);
            
            int nx = x + now[0];
            int ny = y + now[1];
            
            if(nx < -5 || nx > 5 || ny < -5 || ny > 5) continue;
            
            set.add(x + "->" + nx + ", " + y + "->" + ny);
            set.add(nx + "->" + x + ", " + ny + "->" + y);
            
            x = nx;
            y = ny;
        }
              
        return set.size() / 2;
    }
}