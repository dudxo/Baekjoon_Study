import java.util.*;

class Solution {
    
    static String[] str;
    static boolean[] isUsed;
    static Set<Integer> set;
    
    public int solution(String numbers) {
        int answer = 0;
        
        str = numbers.split("");
        set = new HashSet<>();
        
        for(int i = 1; i <= numbers.length(); i++) {
            isUsed = new boolean[str.length];
            dfs(0, new String[i]);
        }
        
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

    private static void dfs(int depth, String[] arr) {
        if(depth == arr.length) {
            add(arr);
            return;
        }
        
        for(int i = 0; i < str.length; i++) {
            if(isUsed[i]) continue;
            
            isUsed[i] = true;
            arr[depth] = str[i];
            dfs(depth+1, arr);
            isUsed[i] = false;
        }
    }
    
    private static void add(String[] arr) {
        String tmp = "";
        for(String s : arr) {
            tmp += s;
        }
        
        set.add(Integer.parseInt(tmp));
    }
    

}