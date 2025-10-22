import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        
        int s = 0, e = people.length - 1;
        boolean[] check = new boolean[people.length];
        
        while(s < e) {
            int sum = people[s] + people[e];
            if(sum > limit) {
                e--;
            }
            
            else {
                check[s] = true;
                check[e] = true;
                answer++;
                s++;
                e--;
           }
        }
        
        for(boolean b : check) {
            if(!b) answer++;
        }
        
        return answer;
    }
}

// 50 60 70 80 90

// 50 60, 70, 80, 90
// 50,80 70,60, 90
// 130