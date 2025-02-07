import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < numbers.length; i++) {
            for(int j = i+1; j < numbers.length; j++) {
                list.add(numbers[i] + numbers[j]);
            }
        }
        
        Object[] oArr = list.stream().distinct().toArray();
        int[] answer = new int[oArr.length];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = (int) oArr[i];
        }
        Arrays.sort(answer);
        
        
        return answer;
    }
}