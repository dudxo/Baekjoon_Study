import java.util.*;

class Solution {
    
    static long st, ed;
    static int len;
    static int[] d, t;
    
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        
        len = diffs.length;
        d = new int[len];
        t = new int[len];
        for(int i = 0; i < len; i++) {
            d[i] = diffs[i];
            t[i] = times[i];
        }
        
        Arrays.sort(diffs);
        st = diffs[0];
        ed = diffs[len-1];
        
    
        answer = binary_sarch(st, ed, limit);
        
        return answer;
    }
    
    private static int binary_sarch(long st, long ed, long limit) {
        long result = 0;
        
        while(st <= ed) {
            long mid = (st + ed) / 2;
            long a = sol(mid);
            // System.out.printf("%d Level : %d!!\n", mid, a);
            if(a <= limit) {
                result = mid;
                ed = mid - 1;
            } else {
                st = mid + 1;
            }
        }
        
        return (int)result;
    }
    
    private static long sol(long level) {
        long total = 0L;
        long t_prev = 0L;
        
        for(int i = 0; i < len; i++) {
            // System.out.printf("%d Level : %d!!\n", level, total);

            int diff = d[i];
            int time = t[i];
            
            // System.out.printf("%d Level : diff = %d, time = %d!!\n", level, diff, time);

            if(diff <= level) {
                total += time;
            }
            
            else {
                int sub = diff - (int) level;
                total += ((time + t_prev) * sub) + time;
            }
            
            t_prev = time;
        }
        // System.out.printf("%d Level : %d!!\n", level, total);
        return total;
    }
}