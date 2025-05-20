import java.util.*;

class Solution {
    static String[] arr = new String[] {"aya", "ye", "woo", "ma"};
    static ArrayDeque<String> dq = new ArrayDeque<>();
    static HashMap<String, String> map = new HashMap<>();

    public int solution(String[] babbling) {
        int answer = 0;

        dq.add("aya");
        dq.add("ye");
        dq.add("woo");
        dq.add("ma");
        
        // // 조합
        // for(int i = 0; i < 4; i++) {
        //     recur(0, new String(""));
        //     dq.addLast(dq.removeFirst());
        // }
        
        // for(String key : map.keySet()) {
        //     System.out.println(map.get(key));
        // }
        
        for(String s : babbling) {
            for(String str : arr) {
                s = s.replace(str, " ");
            }
            System.out.println(s);
            
            s = s.replace(" ", "");
            
            if(s.length() == 0) {
                answer++;
            }
            
//             if(map.get(s) != null) {
//                 System.out.println(s);
//                 answer++;
//             }
        }
        
        return answer;
    }
    
    private static void recur(int cur, String str) {
        if(cur > 4) {
            return;
        }
        
        if(cur == 4) {
            map.put(str, str);
            return;
        }
        
        // 현재 문자를 더하기
        recur(cur+1, str+arr[cur]);
        
        // 현재 문자 안쓰고 넘어가기
        recur(cur+1, str);
    }
}