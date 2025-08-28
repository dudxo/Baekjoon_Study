import java.util.*;
import java.time.*;

class Solution {
    
    public List<Integer> solution(String today, String[] terms, String[] privacies) {        
        String[] sArr = today.split("\\.");
        Integer toYear = Integer.parseInt(sArr[0]);
        Integer toMonth = Integer.parseInt(sArr[1]);
        Integer toDay = Integer.parseInt(sArr[2]);
        LocalDate toDate = LocalDate.of(toYear, toMonth, toDay);
        
        Map<String, Integer> termMap = new HashMap<>();        
        List<Integer> ans = new ArrayList<>();
        
        for(String term : terms) {
            String[] arr = term.split(" ");
            termMap.put(arr[0], Integer.parseInt(arr[1]));
        } 
        
        int index = 1;
        for(String privacie : privacies) {
            String[] arr = privacie.split(" ");
            Integer term = termMap.get(arr[1]);
            
            String[] dateArr = arr[0].split("\\.");
            int year = Integer.parseInt(dateArr[0]);
            int month = Integer.parseInt(dateArr[1]);
            int day = Integer.parseInt(dateArr[2]);
            
            month += term;
            
            if(day == 1) {
                if(month == 1) {
                    year -= 1;
                    month = 12;
                } else {
                    month -= 1;
                }
                
                day = 28;
            } else {
                day -= 1;
            }
            
                        
            if(month > 12) {
                year += (month - 1) / 12;
                month = (month - 1) % 12 + 1;
            }
            
            LocalDate end = LocalDate.of(year, month, day);
            
            if(toDate.isAfter(end)) {
                ans.add(index);
            }
            
            index++;
        }
        
        return ans;
    }
}