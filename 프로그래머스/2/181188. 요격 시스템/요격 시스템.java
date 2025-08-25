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
            if(this.e == o.e) {
                return this.s - o.s;
            }
            
            return this.e - o.e;
        }
    }
    
    public int solution(int[][] targets) {
        
        List<Node> list = new ArrayList<>();
        
        for(int[] target : targets) {
            list.add(new Node(target[0], target[1]));
        }
        
        Collections.sort(list);
        
        int answer = 0;
        int pos = 0;
        
        for(int i = 0; i < list.size(); i++) {
            Node node = list.get(i);
            if(node.s >= pos) {
                answer++;
                pos = node.e;
            }
        }
        
        return answer;
    }
}