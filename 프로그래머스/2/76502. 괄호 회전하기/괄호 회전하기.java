import java.util.*;

class Solution {
    
    static ArrayDeque<Character> dq;
    static int num = 0;
    
    public int solution(String s) {
        int answer = 0;
        
        dq = new ArrayDeque<>();;
        
        for(int i = 0; i < s.length(); i++) {
            dq.clear();
            init(s);
            
            move(i);
            
            if(check()) answer++;
        }
        
        return answer;
    }
    
    private static void init(String s) {
        for(char c : s.toCharArray()) {
            dq.add(c);
        }
    }
    
    private static void move(int i) {
        for(int j = 0; j < i; j++) {
            dq.addLast(dq.remove());
        }
    }
    
    private static boolean check() {
        Stack<Character> stack = new Stack<>();
        stack.add(dq.remove());
        
        while(!dq.isEmpty()) {
            if(stack.isEmpty()) {
                stack.add(dq.remove());
                continue;
            }
            
            char pc = stack.peek();
            char qc = dq.peek();
            
            if(qc == ')') {
                if(pc == '(') {
                    dq.remove();
                    stack.pop();
                    continue;
                }
                return false;
            }
            
            if(qc == ']') {
                if(pc == '[') {
                    dq.remove();
                    stack.pop();
                    continue;
                }
                return false;
            }
            
            if(qc == '}') {
                if(pc == '{') {
                    dq.remove();
                    stack.pop();
                    continue;
                }
                return false;
            }
            
            stack.add(dq.remove());
        }
        
        return stack.isEmpty();
    }
}