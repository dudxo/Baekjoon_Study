import java.util.*;

class Solution {
    
    static class Plan implements Comparable<Plan> {
        int start;
        String name;
        int playtime;
        
        Plan(String name, int start, int playtime) {
            this.start = start;
            this.name = name;
            this.playtime = playtime;
        }
        
        @Override
        public int compareTo(Plan o) {
            return Integer.compare(this.start, o.start);
        }
    }
    
    public List<String> solution(String[][] plans) {
        List<String> result = new ArrayList<>();
        
        List<Plan> ps1 = new ArrayList<>();  // 맨 처음
        Deque<Plan> ps2 = new ArrayDeque<>();  // 대기
        
        for(String[] p : plans) {
            String[] sArr = p[1].split(":");
            int time = Integer.parseInt(sArr[0]) * 60;
            time += Integer.parseInt(sArr[1]);
            ps1.add(new Plan(p[0], time, Integer.parseInt(p[2])));
        }
        
        Collections.sort(ps1);
        int t = ps1.get(0).start;
        
        while(!ps1.isEmpty()) {
            // System.out.println("t = " + t);
            
            // 다음 진행할 과제가 있을 때
            if(ps1.size() >= 2) {
                Plan p1 = ps1.remove(0);
                Plan p2 = ps1.get(0);

                // System.out.println("p1.start = " + p1.start + ", p2.start = " + p2.start);
                
                int studytime = p2.start - t;
                
                // System.out.println("p1.name = " + p1.name + ", p2.name = " + p2.name);
                
                if(p1.playtime <= studytime) {
                    if(p1.playtime < studytime && !ps2.isEmpty()) {
                        ps1.add(0, ps2.poll());
                        t += p1.playtime;
                    } else {
                        t = p2.start;
                    }
                    
                    result.add(p1.name);
                }
                else {
                    p1.playtime = p1.playtime - studytime;
                    ps2.addFirst(p1);
                    t = p2.start;
                }

                // if(!ps2.isEmpty() && ps2.peek().start < p2.start) {
                //     ps1.add(ps2.poll());
                // }

                // t = ps1.get(0).start;
            }
            // 마지막 과제
            else {
                result.add(ps1.remove(0).name);
            }
        }
        
        while(!ps2.isEmpty()) {
            result.add(ps2.poll().name);
        }
        
        return result;
    }
}