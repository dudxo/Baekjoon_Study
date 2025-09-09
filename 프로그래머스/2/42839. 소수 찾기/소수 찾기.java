import java.util.*;

class Solution {
    
    static char[] cArr;
    static boolean[] isUsed;
    static Set<Integer> set;
    
    public int solution(String numbers) {
        int answer = 0;
        
        cArr = numbers.toCharArray();
        set = new HashSet<>();
        
        isUsed = new boolean[cArr.length];
        dfs(0, new StringBuilder());
        
        int max = Integer.MIN_VALUE;
        for(Integer i : set) {
            max = Math.max(i, max);
        }
        
        boolean[] prime = new boolean[max+1];
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;
        
        for(int i = 1; i <= max; i++) {
            if(!prime[i]) continue;
            for(int j = i * 2; j <= max; j += i) {
                prime[j] = false;
            }
        }
        
        for(Integer i : set) {
            if(prime[i]) answer++;
        }

        
        return answer;
    }

    private static void dfs(int depth, StringBuilder sb) {
        if(sb.length() > 0) {
            set.add(Integer.parseInt(sb.toString()));
        }
        if(depth == cArr.length) {
            return;
        }
        
        for(int i = 0; i < cArr.length; i++) {
            if(isUsed[i]) continue;
            
            isUsed[i] = true;
            sb.append(cArr[i]);
            dfs(depth+1, sb);
            sb.deleteCharAt(sb.length() - 1);
            isUsed[i] = false;
        }
    }
    

}