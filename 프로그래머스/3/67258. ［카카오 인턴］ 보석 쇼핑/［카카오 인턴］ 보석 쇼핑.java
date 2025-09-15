import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = {1, gems.length};
        
        Set<String> set = new HashSet<>();
        for(String s : gems) {
            set.add(s);
        }
        int size = set.size();
        
        Map<String, Integer> map = new HashMap<>();
        map.put(gems[0], 1);
        
              
        int s = 0, e = 0;
        
        while(s <= e) {
            // 모든 보석 갖고 있고, 구간이 더 짧음
            if(map.size() == size && (e - s) < (answer[1] - answer[0]) ) {
                answer[0] = s + 1;
                answer[1] = e + 1;
            }
            
            // 모든 보석보다 적음
            if(map.size() < size) {
                if(++e == gems.length) break;
                map.merge(gems[e], 1, Integer::sum);
            }
                        
            else {
                map.merge(gems[s], -1, Integer::sum);
                if(map.get(gems[s]) == 0) map.remove(gems[s]);
                s++;
            }
        }
        
        
        
        return answer;
    }
}