import java.util.*;

class Solution {
    
    static int time;
    static class Server {
        int returnTime;
        
        Server(int returnTime) {
            this.returnTime = returnTime;
        }
    }
    
    static ArrayDeque<Server> dq;
    
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        
        dq = new ArrayDeque<>();
        time = 0;
        
        for(int p : players) {
            // 증설된 서버 반납
            while(!dq.isEmpty()) {
                Server server = dq.peek();
                
                if(server.returnTime > time) {
                    break;
                }
                
                dq.remove();
            }
            
            // 게임 이용자 수에 따른 서버 증설 여부 판단
            if(p >= m) {
                int mod = (p / m) - dq.size();
                if(mod > 0) {
                    for(int i = 0; i < mod; i++) {
                        dq.addLast(new Server(time+k));
                    }
                    answer += mod;
                }
            }
            
            // 시각 증가
            time++;
        }
        
        return answer;
    }
}