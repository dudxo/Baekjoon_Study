import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int pick = nums.length / 2;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        int cnt = 0;
        for(Integer key : map.keySet()) {
            cnt += 1;
        }
        
        answer = cnt > pick ? pick : cnt;
        
        return answer;
    }
}