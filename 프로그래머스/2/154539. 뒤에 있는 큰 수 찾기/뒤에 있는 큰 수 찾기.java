import java.util.*;

class Solution {
    public List<Integer> solution(int[] numbers) {
        List<Integer> answer = new ArrayList<>();
        
        int len = numbers.length;
        Stack<Integer> s = new Stack<>();
        
        answer.add(-1);
        s.push(numbers[len-1]);
        
        for(int i = len-2; i >= 0; i--) {
            if(numbers[i] < numbers[i+1]) {
                answer.add(numbers[i+1]);
            }
            else {
                while(!s.isEmpty() && s.peek() <= numbers[i]) {
                    s.pop();
                }
                
                answer.add(s.isEmpty() ? -1 : s.peek());
            }
            s.push(numbers[i]);          
        }
        
        Collections.reverse(answer);
        
        return answer;
    }
}