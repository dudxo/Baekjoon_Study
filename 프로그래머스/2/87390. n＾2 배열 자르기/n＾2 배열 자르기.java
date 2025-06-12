import java.util.*;

class Solution {
    
    
    public int[] solution(int n, long left, long right) {
        
        ArrayList<Integer> list = new ArrayList<>();
        for(; left <= right; left++) {
            long mod = left % n;
            long div = left / n;
            
            if(mod >= div) {
                list.add((int)mod+1);
            } else {
                list.add((int)div+1);
            }
        }
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        
        return answer;
    }
}