import java.util.*;

class Solution {
    
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        int len = timelogs.length;
        int sLen = schedules.length;

        int[][] arr = new int[sLen][2];
        int t;
        for(int i = 0; i < sLen; i++) {
            t = schedules[i];
            
            arr[i][0] = t;
            
            if((t+10) % 100 >= 60) {
                arr[i][1] = (t + 110) - 60;
            } else {
                arr[i][1] = t + 10;
            }
        }
        
        boolean flag;
        int day;
        for(int i = 0; i < len; i++) {
            flag = true;
            day = startday;
            
            for(int j = 0; j < 7; j++) {
                if(day == 6) {
                    day++;
                    continue;
                }
                if(day == 7) {
                    day = 1;
                    continue;
                }

                t = timelogs[i][j];

                if(arr[i][1] < t) {
                    flag = false;
                    break;
                }
                
                day++;

            }
            
            if(flag) {
                answer++;
            }
        }
        
        return answer;
    }
}