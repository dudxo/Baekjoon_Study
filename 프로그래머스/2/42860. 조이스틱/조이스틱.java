import java.util.*;

class Solution {
    
    static int len, cur, answer;
    static char[] nameArr, c;
    
    public int solution(String name) {
        answer = 0;
        
        cur = 0;
        len = name.length();
        nameArr = name.toCharArray();
        c = new char[len];
        
        
        // System.out.printf("[%C - %C] = [%d]\n", 'J', 'A', 'J' - 'A');
        // System.out.printf("[%C - %C] = [%d]\n", 'E', 'A', 'E' - 'A');
        // System.out.printf("[%C - %C] = [%d]\n", 'R', 'A', 'R' - 'A');
        // System.out.printf("[%C - %C] = [%d]\n", 'O', 'A', 'O' - 'A');
        // System.out.printf("[%C - %C] = [%d]\n", 'E', 'A', 'E' - 'A');
        // System.out.printf("[%C - %C] = [%d]\n", 'N', 'A', 'N' - 'A');
        

        
        for(int i = 0; i < len; i++) {
            c[i] = 'A';
        }
        
        if(check()) {
            return 0;
        }
        
        
        for(int i = 0; i < len; i++) {
            if(c[cur] != nameArr[cur]) {
                int up = nameArr[cur] - 'A';
                int down = 'Z' - nameArr[cur] + 1;
                if(up < down) {
                    answer += up;
                    System.out.printf("[%d] 증가!! \n",  up);
                } else {
                    System.out.printf("[%d] 증가!! \n", down);
                    answer += down;
                }
                

                
                c[cur] = nameArr[cur];
            }
            
            if(check()) {
                break;
            }        
            
            move();
        }
        // A A B A A
        // A A B A B
        
        
        return answer;
    }
    
    private static void move() {
        int[] l = left();
        int[] r = right();
        
        System.out.printf("좌측 이동 변경 위치 : [%d], 우측 이동 변경 위치 : [%d]\n", l[1], r[1]);
        
        // 더 이상 없음
        if(l[0] == -1 && r[0] == -1) {
            return;
        }
        
        if(l[0] == -1) {
            answer += r[1];
            cur = r[0];
            return;
        }
        
        if(r[0] == -1) {
            answer += l[1];
            cur = l[0];
            return;
        }
        
        if(l[1] < r[1]) {
            System.out.printf("[%d] 증가!! \n",  l[1]);
            answer += l[1];
            cur = l[0];
            
        } else {
            System.out.printf("[%d] 증가!! \n",  r[1]);

            answer += r[1];
            cur = r[0];
        }
        
        return;
    }
    
    private static int[] left() {
        int l = cur;
        int cnt = 0;
        while(c[l] == nameArr[l]) {
            cnt++;
            l--;
            if(l < 0) l = len-1;
            if(l == cur) return new int[] {-1, -1};
        }
        return new int[] {l, cnt};
    }
    
    private static int[] right() {
        int r = cur;
        int cnt = 0;
        while(c[r] == nameArr[r]) {
            cnt++;
            r++;
            if(r >= len) r = 0;
            if(r == cur) return new int[] {-1, -1};
        }
        return new int[] {r, cnt};
    }
    
    private static boolean check() {
        for(int i = 0; i < len; i++) {
            if(nameArr[i] != c[i]) return false;
        }
        
        return true;
    }
}