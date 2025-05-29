import java.util.*;

class Solution {
    
    static class Node {
        int priority;
        int location;
        
        Node(int priority, int location) {
            this.priority = priority;
            this.location = location;
        }
    }
    
    public int solution(int[] priorities, int location) {
        ArrayDeque<Node> q = new ArrayDeque<>();
        
        for(int i = 0; i < priorities.length; i++) {
            q.add(new Node(priorities[i], i));
        }
        
        // for(Node n : q) {
        //     System.out.println(n.location);
        // }
        
        int answer = 1;
        while(!q.isEmpty()) {
            Node now = q.poll();
            int size = q.size();
            boolean flag = true;
            for(int i = 0; i < size; i++) {
                Node next = q.poll();
                if(next.priority > now.priority) {
                    flag = false;
                }
                q.add(next);
            }
            
            if(!flag) {
                q.add(now);
                continue;
            }
            
            if(now.location == location) break;
            
            answer++;
        }
        
        return answer;
    }
}