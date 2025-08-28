import java.util.*;

class Solution {
    
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    
    public int solution(String[][] board, int h, int w) {
        int answer = 0;

        String color = board[h][w];
        
        for(int k = 0; k < 4; k++) {
            int nx = h + dx[k];
            int ny = w + dy[k];
            
            if(nx < 0 || ny < 0 || nx >= board.length || ny >= board[0].length) continue;
            
            if(color.equals(board[nx][ny])) answer++;
        }
        
        return answer;
    }
}