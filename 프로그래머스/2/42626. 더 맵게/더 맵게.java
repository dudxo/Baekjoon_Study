import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i : scoville) {
            pq.add(i);
        }
        
        
        int a, b, tmp;
        
        while(pq.size() > 1) {
            a = pq.peek();
            
            if(a >= K) break;
            
            a = pq.poll();
            b = pq.poll();
            
            tmp = a + (b * 2);
            pq.add(tmp);
            answer++;
        }
        
        if(pq.peek() < K) return -1;
        
        return answer;
    }
}