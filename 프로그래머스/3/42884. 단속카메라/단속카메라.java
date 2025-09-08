import java.util.*;

class Solution {
    
    static class Node implements Comparable<Node> {
        int s, e;
        
        Node(int s, int e) {
            this.s = s;
            this.e = e;
        }
        
        @Override
        public int compareTo(Node o) {
            if(this.e == o.e) return this.s - o.s;
            
            return this.e - o.e;
        }
    }
    
    public int solution(int[][] routes) {
        int answer = 0;
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        for(int[] route : routes) {
            pq.add(new Node(route[0], route[1]));
        }
        
        int e = pq.poll().e;
        answer++;
        
        while(!pq.isEmpty()) {
            Node now = pq.poll();
            if(e < now.s) {
                answer++;
                e = now.e;
            }
        }
        
        return answer;
    }
}