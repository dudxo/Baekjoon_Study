import java.util.*;

class Solution {
    
    static int[] up, down;
    static Stack<Integer> trash;
    static int cur, max;
    
    public String solution(int n, int k, String[] cmd) {
        
        trash = new Stack<>();
        up = new int[n+2];
        down = new int[n+2];
        
        for(int i = 0; i < n+2; i++) {
            up[i] = i - 1;
            down[i] = i + 1;
        }
        
        k++;
        
        for (String c : cmd) {
            if(c.startsWith("C")) {
                trash.push(k);
                up[down[k]] = up[k];
                down[up[k]] = down[k];
                k = n < down[k] ? up[k] : down[k];
            }
            
            else if(c.startsWith("Z")) {
                int restore = trash.pop();
                down[up[restore]] = restore;
                up[down[restore]] = restore;
            }
            
            else {
                String[] s = c.split(" ");
                int x = Integer.parseInt(s[1]);
                
                for(int i = 0; i < x; i++) {
                    k = s[0].equals("U") ? up[k] : down[k];
                }
            }
        }
        
        char[] answer = new char[n];
        Arrays.fill(answer, 'O');
        
        for(int i : trash) {
            answer[i - 1] = 'X';
        }
        
        return new String(answer);
    }
}