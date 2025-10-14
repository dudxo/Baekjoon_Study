import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        
        Deque<String> dq1 = new ArrayDeque<>();
        Deque<String> dq2 = new ArrayDeque<>();
        
        for(String s : cards1) {
            dq1.addLast(s);
        }
        
        for(String s : cards2) {
            dq2.addLast(s);
        }
        
        for(String s : goal) {
            if(s.equals(dq1.peek())) {
                dq1.remove();
                continue;
            }
            
            if(s.equals(dq2.peek())) {
                dq2.remove();
                continue;
            }
            
            return "No";
        }
        
        return "Yes";
    }
}