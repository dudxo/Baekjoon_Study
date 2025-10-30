import java.util.*;

class Solution {
    
    static int max;
    
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;
        
        for(int e : enemy) {
            pq.add(e);
            n -= e;
            
            if(n < 0) {
                if(k > 0) {
                    n += pq.poll();
                    k--;
                } else {
                    break;
                }
            }
            answer++;
        }
        
        return answer;
    }
}