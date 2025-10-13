import java.util.*;

class Solution {
    
    static class Job implements Comparable<Job> {
        int index, progress, speed;
        
        Job(int index, int progress, int speed) {
            this.index = index;
            this.progress = progress;
            this.speed = speed;
        }
        
        @Override
        public int compareTo(Job o) {
            return this.index - o.index;
        }
        
        public void process() {
            this.progress += speed;
        }
    }
    
    public List<Integer> solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        
        Deque<Job> jobs = new ArrayDeque<>();
        
        int len = progresses.length;
        for(int i = 0; i < len; i++) {
            jobs.add(new Job(i, progresses[i], speeds[i]));
        }
        
        int size = 0, cnt = 0;
        while(!jobs.isEmpty()) {
            size = jobs.size();
            
            for(int i = 0; i < size; i++) {
                Job job = jobs.removeFirst();
                job.process();
                jobs.addLast(job);
            }
            
            cnt = 0;
            
            for(int i = 0; i < size; i++) {
                if(jobs.peek().progress < 100) {
                    break;
                }
                
                jobs.removeFirst();
                cnt++;
            }
            
            if(cnt > 0) answer.add(cnt);
        }
        
        
        return answer;
    }
}