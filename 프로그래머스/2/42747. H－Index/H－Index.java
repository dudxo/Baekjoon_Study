import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int len = citations.length;
        
        Arrays.sort(citations);
        int n = 0, m = 0;
       
        
        for(int i = 0; i < len; i++) {
            if(citations[i] >= len-i) {
                answer = len - i;
                break;
            }
        }
        
        return answer;
    }
}