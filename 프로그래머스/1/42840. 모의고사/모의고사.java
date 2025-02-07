import java.util.*;

class Solution {
    
    static final int[] GIVE_UP_1 = {1, 2, 3, 4, 5};
    static final int[] GIVE_UP_2 = {2, 1, 2, 3, 2, 4, 2, 5};
    static final int[] GIVE_UP_3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    
    public int[] solution(int[] answers) {
        int cur = 0;
        int countA = 0, countB = 0, countC = 0;
        
        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == GIVE_UP_1[i % GIVE_UP_1.length]) {
                countA += 1;
            }
            if(answers[i] == GIVE_UP_2[i % GIVE_UP_2.length]) {
                countB += 1;
            }
            if(answers[i] == GIVE_UP_3[i % GIVE_UP_3.length]) {
                countC += 1;
            }
        }
        
        int max = Math.max(countA, Math.max(countB, countC));
        
        ArrayList<Integer> list = new ArrayList<>();
        if(max == countA) {
            list.add(1);
        }
        if(max == countB) {
            list.add(2);
        }
        if(max == countC) {
            list.add(3);
        }
        
        return list.stream().sorted().mapToInt(Integer::intValue).toArray();
        
    }
}