import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        
        PriorityQueue<Integer> rq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> q = new PriorityQueue<>();
        
        for(String op : operations) {
            String[] ops = op.split(" ");
            
            if(ops[0].equalsIgnoreCase("i")) {
                rq.add(Integer.parseInt(ops[1]));
                q.add(Integer.parseInt(ops[1]));
                continue;
            }
            
            if(rq.isEmpty() && q.isEmpty()) continue;
            
            int num;
            if(ops[1].equals("1")) {
                num = rq.remove();
                q.remove(num);
            } else {
                num = q.remove();
                rq.remove(num);
            }
            
        }
        
        if(rq.isEmpty() && q.isEmpty()) return new int[] {0, 0};
                
        int[] answer = new int[] {rq.poll(), q.poll()};
        return answer;
    }
}