import java.util.*;

class Solution {
    
    static Map<String, Integer> map;
    
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        map = new HashMap<>();
        boolean flag = false;
        
        int len = discount.length - 10;
        
        init(discount);
        if(sol(want, number)) {
            answer++;
            flag = true;
        }
           
        for(int i = 1; i <= len; i++) {
            // 전 날에 회원가입이 가능 할 때
            if(flag) {
                if(discount[i-1].equals(discount[i+9])) {
                    answer++;
                } else {
                    map.put(discount[i-1], map.get(discount[i-1]) - 1);
                    map.put(discount[i+9], map.getOrDefault(discount[i+9], 0) + 1);
                    flag = false;   
                }
                continue;
            }
            
            // 회원가입 가능 여부 판단
            map.put(discount[i-1], map.get(discount[i-1]) - 1);
            map.put(discount[i+9], map.getOrDefault(discount[i+9], 0) + 1);
            
            if(sol(want, number)) {
                answer++;
                flag = true;
            }
        }
        
        return answer;
    }
    
    private static void init(String[] discount) {
        for(int i = 0; i < 10; i++) {
            map.put(discount[i], map.getOrDefault(discount[i], 0) + 1);
        }
    }
    
    private static boolean sol(String[] want, int[] number) {
        int len = want.length;
        
        String key = "";
        int num = 0;
        for(int i = 0; i < len; i++) {
            key = want[i];
            num = number[i];
            
            if(map.get(key) == null || map.get(key) != num) return false;
        }
        
        return true;
    }
    
    /*
    1~10: 3 2 2 2 1
    2~11: 3 2 2 2 1
    3~12: 3 2 2 2 1
    4~13: 3 2 1 2 1 1
    5~14: 3 2 2 2 1 
    */
    
}