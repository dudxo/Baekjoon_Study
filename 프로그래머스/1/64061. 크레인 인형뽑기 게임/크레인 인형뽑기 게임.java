import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack<>();
        
        int len = board.length;
        
        for(int move : moves) {
            for(int i = 0; i < len; i++) {
                if(board[i][move-1] == 0) continue;
                
                int doll = board[i][move-1];
                board[i][move-1] = 0;
                if(!stack.isEmpty() && stack.peek() == doll) {
                    stack.pop();
                    answer++;
                } else {
                    stack.push(doll);
                }
                
                break;
            }
        }
        
        return answer * 2;
    }
}