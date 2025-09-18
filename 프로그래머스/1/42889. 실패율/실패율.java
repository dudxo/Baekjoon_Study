import java.util.*;

class Solution {
    
    static class Node implements Comparable<Node> {
        int stage;
        double fail;
        
        Node(int stage, double fail) {
            this.stage = stage;
            this.fail = fail;
        }
        
        @Override
        public int compareTo(Node o) {
            if(this.fail == o.fail) {
                return this.stage - o.stage;
            }
            
            return this.fail < o.fail ? 1 : -1;
        }
    }
    
    public int[] solution(int N, int[] stages) {
        
        int p = stages.length;

        int[] arr = new int[N+1];
        int[] pArr = new int[N+1];
        
        for(int s : stages) {
            if(s == N+1) { 
                for(int i = 1; i <= N; i++) {
                    arr[i]++;
                }
                continue;
            }
            
            pArr[s]++;
            for(int i = 1; i <= s; i++) {
                arr[i]++;
            }
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int i = 1; i <= N; i++) {
            if(arr[i] == 0) {
                pq.add(new Node(i, 0));
                continue;
            }
            
            pq.add(new Node(i, (double) pArr[i] / arr[i]));
        }
        
        int[] answer = new int[N];
        for(int i = 0; i < N; i++) {
            answer[i] = pq.poll().stage;
        }
        
        return answer;
    }
}