import java.util.*;

class Solution {
    
    static class Node implements Comparable<Node> {
        String num;
        
        Node(String num) {
            this.num = num;
        }
        
        @Override
        public int compareTo(Node o) {
            return Integer.parseInt(o.num + this.num) - Integer.parseInt(this.num + o.num);
        }
        
    }
    
    public String solution(int[] numbers) {
        List<Node> list = new ArrayList<>();
        
        for(int i : numbers) {
            list.add(new Node(String.valueOf(i)));
        }
        
        Collections.sort(list);
        
        if(list.get(0).num.equals("0")) {
            return "0";
        }
        
        String answer = "";
        
        for(Node node : list) {
            answer += node.num;
        }
        
        return answer;
    }
}