import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {        
        long sum1 = 0L;
        long sum2 = 0L;

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        for(int i : queue1) {
            sum1 += i;
            q1.add(i);
        }
        
        for(int i : queue2) {
            sum2 += i;
            q2.add(i);
        }
        
        if(sum1 == sum2) return 0;
        
        long len = queue1.length + queue2.length + 1;
        
        int count = 0;
        int num1 = 0, num2 = 0;
        
        while(count <= len && !q1.isEmpty() && !q2.isEmpty()) {
            num1 = q1.peek();
            num2 = q2.peek();
            
            if(sum1 > sum2) {
                q2.add(q1.poll());
                sum1 -= num1;
                sum2 += num1;
            } else {
                q1.add(q2.poll());
                sum1 += num2;
                sum2 -= num2;
            }
            
            count++;
            
            if(sum1 == sum2) return count;
        }
        
        return -1;
    }
}