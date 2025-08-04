import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Arrays.sort(phone_book);
        
        Map<String, String> map = new HashMap<>();
        for(String phone : phone_book) {
            if(map.isEmpty()) {
                map.put(phone, phone);
                continue;
            }
            
            for(int i = 0; i < phone.length(); i++) {
                if(map.get(phone.substring(0, i)) != null) {
                    answer = false;
                    break;
                }
            }
            
            
            if(!answer) break;
            map.put(phone, phone);
        }
        
        
        return answer;
    }
}