import java.util.*;

class Solution {
    
    public String solution(String number, int k) {
        String answer = "";
        
        Stack<Character> stack = new Stack<>();
        
        char[] arr = number.toCharArray();
        for(char c : arr) {
            while(!stack.isEmpty() && k > 0 && stack.peek() < c) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        
        while(k-- > 0) {
            stack.pop();
        }
        
        ArrayDeque<Character> dq = new ArrayDeque<>();
        while(!stack.isEmpty()) {
            dq.add(stack.pop());
        }
        
        while(!dq.isEmpty()) {
            answer += dq.removeLast();
        }
        
        
        return answer;
    }
    
}