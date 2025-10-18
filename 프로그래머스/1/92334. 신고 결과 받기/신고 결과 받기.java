import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        Map<String, Set<String>> reportedMap = new HashMap<>(); // key를 신고한 사람
        Map<String, Integer> reportMap = new HashMap<>();  // key가 신고 받은 횟수
        Map<String, Set<String>> recordMap = new HashMap<>(); // key가 신고한 기록
        Map<String, Integer> mailMap = new HashMap<>();
        
        for(String id : id_list) {
            reportedMap.put(id, new HashSet<>());
            reportMap.put(id, 0);
            recordMap.put(id, new HashSet<>());
            mailMap.put(id, 0);
        }
        
        for(String s : report) {
            String[] r = s.split(" ");
            String u = r[0];
            String v = r[1];
            
            Set<String> recordSet = recordMap.get(u);
            int size = recordSet.size();
            
            recordSet.add(v);
            // 이미 신고했음
            if(size == recordSet.size()) {
                continue;
            }
            
            recordMap.put(u, recordSet);
            
            reportMap.put(v, reportMap.get(v) + 1);
            Set<String> reportedSet = reportedMap.get(v);
            reportedSet.add(u);
            
            reportedMap.put(v, reportedSet);
        }
        
        for(String key : reportMap.keySet()) {
            int num = reportMap.get(key);
            
            if(num >= k) {
                Set<String> reportedSet = reportedMap.get(key);
                for(String id : reportedSet) {
                    mailMap.put(id, mailMap.get(id) + 1);
                }
            }
        }
        
        for(int i = 0; i < id_list.length; i++) {
            String key = id_list[i];
            answer[i] = mailMap.get(key);
        }
        
        return answer;
    }
}