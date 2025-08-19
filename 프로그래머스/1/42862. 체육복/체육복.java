import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        ArrayDeque<Integer> lq = new ArrayDeque<>();
        ArrayDeque<Integer> rq = new ArrayDeque<>();
        
        for(int l : lost) {
            lq.add(l);
        }
        
        for(int r : reserve) {
            if(lq.contains(r)) {
                int size = lq.size();
                while(size-- > 0) {
                    int num = lq.remove();
                    
                    if(num == r) {
                        break;
                    }
                    
                    lq.addLast(num);
                }
                
                continue;
            }
            
            rq.add(r);
        }
        
        int size = lq.size();
        while(size-- > 0) {
            int lNum = lq.remove();
            boolean flag = false;
            
            int size2 = rq.size();
            while(size2-- > 0) {
                int rNum = rq.remove();
                
                if(lNum == rNum-1 || lNum == rNum+1) {
                    flag = true;
                    break;
                }
                
                rq.addLast(rNum);
            }
            
            if(!flag) {
                lq.addLast(lNum);
            }
        }
        
        answer += (lost.length - lq.size());
        
        return answer;
    }
}