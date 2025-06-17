import java.util.*;

class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        
        int x = -1, y = -1;
        int mod = n / w;
        int remain = n % w;
        if(remain != 0) {
            mod += 1;
        }
        
        int[][] map = new int[mod+1][w+1];
        int tmp = 1;
        boolean flag = false;
        
        for(int i = 1; i <= mod; i++) {
            if(tmp > n) break;
            
            if(!flag) {
                for(int j = 1; j <= w; j++) {
                    if(tmp == num) {
                        x = i;
                        y = j;
                    }
                    map[i][j] = tmp++;
                    if(tmp > n) break;
                }
            } else {
                for(int j = w; j >= 1; j--) {
                    if(tmp == num) {
                        x = i;
                        y = j;
                    }
                    map[i][j] = tmp++;
                    if(tmp > n) break;
                }
            }
            
            flag = !flag;
        }
        
        
        for(int i = mod; i >= x; i--) {
            if(map[i][y] != 0) answer++;
        }

        return answer;
    }
}