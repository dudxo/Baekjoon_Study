import java.util.*;

class Solution {
    
    static int cnt, num;
    static boolean[] isUsed;
    
    public int solution(int n) {
        int answer = 0;
        
        int n1 = 1, n2 = 1;
        
        while(n2 <= n && n1 <= n2) {
            int tmp = 0;
            for(int i = n1; i <= n2; i++) {
                tmp += i;
            }
            
            if(tmp == n) {
                n1++;
                n2++;
                cnt++;
            }
            
            else if(tmp > n) {
                n1++;
            }
            
            else {
                n2++;
            }
        } 
        
        return cnt;
    }
    


}