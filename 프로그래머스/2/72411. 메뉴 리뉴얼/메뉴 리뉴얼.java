import java.util.*;

class Solution {
    
    static Map<Integer, Map<String, Integer>> combie;
    static boolean[] isUsed;
    
    public List<String> solution(String[] orders, int[] course) {
        
        combie = new HashMap<>();
        for(int c : course) {
            combie.put(c, new HashMap<>());
        }
        
        for(String o : orders) {
            char[] c = o.toCharArray();
            Arrays.sort(c);
            
            for(int i = 1; i <= c.length; i++) {
                isUsed = new boolean[c.length];
                sol(0, i, c, new char[i]);
            }
        }
        
        List<String> answer = new ArrayList<>();
        int max; 
        for(int outterKey : combie.keySet()) {
            max = Integer.MIN_VALUE;
            Map<String, Integer> innerMap = combie.get(outterKey);
            for(String innerKey : innerMap.keySet()) {
                max = Math.max(max, innerMap.get(innerKey));
            }
            
            for(String innerKey : innerMap.keySet()) {
                int cnt = innerMap.get(innerKey);
                if(cnt == max && cnt >= 2) {
                    answer.add(innerKey);
                }
            }
        }
        
        Collections.sort(answer);
        
        return answer;
    }
    
    private static void sol(int k, int depth, char[] c, char[] arr) {
        if(k == depth) {
            if(combie.containsKey(k)) {
                String s = String.valueOf(arr);
                Map<String, Integer> innerMap = combie.get(k);
                innerMap.put(s, innerMap.getOrDefault(s, 0) + 1);
            }
            
            return;
        }
        
        for(int i = 0; i < c.length; i++) {
            if(k > 0 && arr[k-1] > c[i]) {
                continue;
            }
            
            if(!isUsed[i]) {
                arr[k] = c[i];
                isUsed[i] = true;
                sol(k+1, depth, c, arr);
                isUsed[i] = false;
            }
        }
    }
}