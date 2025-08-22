import java.util.*;

class Solution {
    
    // 선물 지수 = 준 선물 - 받은 선물
    // 선물지수 큰 사람 <- 작은 사람
    
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        
        Map<String, Map<String, Integer>> giftHistory = new HashMap<>();
        Map<String, Map<String, Integer>> givenHistory = new HashMap<>();
        Map<String, Integer> given = new HashMap<>();
        Map<String, Integer> gift = new HashMap<>();
        Map<String, Integer> index = new HashMap<>();
        
        for(String name : friends) {
            giftHistory.put(name, new HashMap<>());
            givenHistory.put(name, new HashMap<>());
            given.put(name, 0);
            gift.put(name, 0);
            index.put(name, 0);
        }
        
        for(String str : gifts) {
            String[] sArr = str.split(" ");
            
            String giver = sArr[0];
            String receiver = sArr[1];
            
            Map<String, Integer> innerGiftMap = giftHistory.get(giver);
            innerGiftMap.put(receiver, innerGiftMap.getOrDefault(receiver, 0) + 1);
            giftHistory.put(giver, innerGiftMap);
            
            gift.put(giver, gift.getOrDefault(giver, 0) + 1);
            
            Map<String, Integer> innerGivenMap = givenHistory.get(receiver);
            innerGivenMap.put(giver, innerGivenMap.getOrDefault(giver, 0) + 1);
            givenHistory.put(receiver, innerGivenMap);
            
            given.put(receiver, given.getOrDefault(receiver, 0) + 1);
        }
        
        for(String key : gift.keySet()) {
            int giftCount = gift.get(key);
            int givenCount = given.get(key);
            
            index.put(key, (giftCount - givenCount));
        }
        
        for(String key : giftHistory.keySet()) {
            int count = 0;
            
            Map<String, Integer> innerGiftMap = giftHistory.get(key);
            
            // 선물 주고받은 기록 존재 여부
            for(String other : index.keySet()) {
                // 동일 인물 Skip
                if(key.equals(other)) continue;
                
                Map<String, Integer> innerGivenMap = givenHistory.get(key);
                
                // 기록이 존재한다면
                if(Objects.nonNull(innerGiftMap.get(other)) || Objects.nonNull(innerGivenMap.get(other))) {
                    System.out.printf("[%s] %s와 기록 존재!!\n", key, other);
                    int giftCount = innerGiftMap.getOrDefault(other, 0);
                    int givenCount = innerGivenMap.getOrDefault(other, 0);
                    
                    // System.out.printf("[%s] %s에게 준 횟수 = %d\n", key, other, giftCount);
                    // System.out.printf("[%s] %s에게 받은 횟수 = %d\n", key, other, givenCount);
                    
                    if(giftCount - givenCount > 0) {
                        // System.out.printf("[%s] %s로부터 선물 획득!!\n", key, other);
                        count++;
                        continue;
                    }
                    
                    if(giftCount - givenCount < 0) {
                        System.out.printf("[%s] %s와 기록 존재하나 더 적게 줘서 패스!!\n", key, other);
                        continue;
                    }
                } 
                
                // 기록이 존재하지도 않거나 주고 받은 수가 같다면
                System.out.printf("[%s] %s와 기록 존재하지 않거나 주고 받은 수가 같음!!\n", key, other);
                int giverIndex = index.get(key);
                int otherIndex = index.get(other);
                
                if(giverIndex > otherIndex) {
                    count++;
                    // System.out.printf("[%s] %s로부터 선물 획득!!\n", key, other);
                }
            }
            
            // System.out.printf("[%s].count = %d\n", key, count);
            
            answer = answer < count ? count : answer;
        }
        
        return answer;
    }
}