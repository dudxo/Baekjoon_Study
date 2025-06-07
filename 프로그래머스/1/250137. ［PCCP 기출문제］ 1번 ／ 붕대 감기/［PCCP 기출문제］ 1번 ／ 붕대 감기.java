import java.util.*;

class Solution {
    //t초 동안 붕대감음
    // 1초당 x 만큼 회복
    // t초 연속 성공하면 y만큼 추가 회복
    // 공격당하면 취소됨
    
    static int t, x, y, hp, max;
    static class Node {
        int t, d;
        
        Node(int t, int d) {
            this.t = t;
            this.d = d;
        }
    }
    
    public int solution(int[] bandage, int health, int[][] attacks) {
        t = bandage[0];
        x = bandage[1];
        y = bandage[2];
        hp = health;
        max = health;
        
        int success = 0, time = 1;
        
        ArrayDeque<Node> dq = new ArrayDeque<>();
        for(int[] arr : attacks) {
            dq.addLast(new Node(arr[0], arr[1]));
        }
        
        int last = attacks[attacks.length-1][0];
        
        while(time <= last) {

            if(hp <= 0) break;
            // System.out.printf("%d초 %d 체력\n", time, hp);

            
            Node now = dq.peek();
            if(now.t == time) {
                // System.out.printf("%d초 공격! -> %d 데미지 받음 \n", time, now.d);
                success = 0;
                time++;
                hp -= now.d;
                dq.remove();
                continue;
            }
            
            success++;

            hp += x;
            // System.out.printf("%d초 회복 후 %d 체력\n", time, hp);

            if(success == t) {
                hp += y;
                success = 0;
                // System.out.printf("%d초 연속 성공으로 보너스 회복 후 %d 체력\n", time, hp);

            }
            
            hp = hp > max ? max : hp;
            
            time++;
        }
        
        int answer = hp <= 0 ? -1 : hp;
        return answer;
    }
}