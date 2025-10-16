import java.util.*;

class Solution {
    
    Map<String, String> map;

    public List<String> solution(String[] record) {
        List<String> answer = new ArrayList<>();
        
        map = new HashMap<>();
        for(String s : record) {
            String[] sArr = s.split(" ");
            if(sArr[0].equals("Leave")) continue;
            
            map.put(sArr[1], sArr[2]);
        }
        
        for(String s : record) {
            String[] sArr = s.split(" ");
            switch(sArr[0]) {
                case "Enter":
                    answer.add(map.get(sArr[1]) + "님이 들어왔습니다.");
                    break;
                case "Leave":
                    answer.add(map.get(sArr[1]) + "님이 나갔습니다.");
                    break;
            }
        }
        
        return answer;
    }
}