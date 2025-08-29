import java.util.*;

class Solution {
    
    static class User {
        int ratio, price;
        
        User(int ratio, int price) {
            this.ratio = ratio;
            this.price = price;
        }
    }
    
    static int pCount = 0, amount = 0, len;
    static List<User> list = new ArrayList<>();
    
    
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = {};
        
        len = emoticons.length;
        
        //할인율 1~40
        //하나씩 다 돌면서 최대값 찾으면 됨
        //백트레킹으로 해볼까?
        
        for(int[] user : users) {
            list.add(new User(user[0], user[1]));
        }
        
        sol(0, new int[len], emoticons);
        
        return new int[] {pCount, amount};
    }
    
    private static void sol(int k, int[] discount, int[] emoticons) {
        if(k >= len) {
            // 행사 목적 최대 달성 여부 체크
            check(discount, emoticons);
            return;
        }
        
        // 10%
        discount[k] = 10;
        sol(k+1, discount, emoticons);
        discount[k] = 0;
        
        // 20%
        discount[k] = 20;
        sol(k+1, discount, emoticons);
        discount[k] = 0;
        
        // 30%
        discount[k] = 30;
        sol(k+1, discount, emoticons);
        discount[k] = 0;
        
        // 40%
        discount[k] = 40;
        sol(k+1, discount, emoticons);
        discount[k] = 0;
    }
    
    private static void check(int[] discount, int[] emoticons) {
        int plus = 0, total = 0, size = list.size();
        
        int[] discountEmoticons = new int[emoticons.length];
        
        for(int i = 0; i < discountEmoticons.length; i++) {
            discountEmoticons[i] = emoticons[i] * (100 - discount[i]) / 100;
        }
        
        for(int i = 0; i < size; i++) {
            User user = list.get(i);
            
            int price = 0;
            
            for(int j = 0; j < discountEmoticons.length; j++) {
                // 이모티콘 플러스 가입 여부에 따른 조기 리턴
                if(user.price <= price) {
                    break;
                }
                
                if(user.ratio <= discount[j]) {
                    price += discountEmoticons[j];
                }
            }
            
            if(user.price <= price) {
                plus += 1;
            } else {
                total += price;
            }
        }
        
        if(pCount < plus) {
            pCount = plus;
            amount = total;
        }
        
        if(pCount == plus) {
            amount = Math.max(amount, total);
        }
    }
}