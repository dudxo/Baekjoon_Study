import java.util.*;


class Solution {
    
    static class Job implements Comparable<Job> {
        int num, req, time;
        
        Job(int num, int req, int time) {
            this.num = num;
            this.req = req;
            this.time = time;
        }
        
        
        // 짧은 작업 소요시간
        // 작업 요청 시각이 빠른
        // 작업 번호가 작은 순
        @Override
        public int compareTo(Job o) {
            if(this.time == o.time) {
                if(this.req == o.req) {
                    return this.num - o.num;
                }
                
                return this.req - o.req;
            }
            
            return this.time - o.time;
        }
    }
    
    static class Node implements Comparable<Node>{
        int n, r, t;
        
        Node(int n, int r, int t) {
            this.n = n;
            this.r = r;
            this.t = t;
        }
        
        @Override
        public int compareTo(Node o) {
            return this.r - o.r;
        }
    }
    
    static PriorityQueue<Job> diskController = new PriorityQueue<>();
    static PriorityQueue<Node> nodes = new PriorityQueue<>();
    static ArrayDeque<Job> queue = new ArrayDeque<>();
    
    public int solution(int[][] jobs) {
        int answer = 0;
        
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        
        for(int i = 0; i < jobs.length; i++) {
            nodes.add(new Node(i, jobs[i][0], jobs[i][1]));
        }
        
        int t = 0, s = 0;
        while(!queue.isEmpty() || !diskController.isEmpty() || !nodes.isEmpty()) {
            // nodes -> disController로 옮기기
            while(!nodes.isEmpty()) {
                Node node = nodes.peek();
                if(node.r == t) {
                    diskController.add(new Job(node.n, node.r, node.t));
                    nodes.poll();                
                    continue;
                }
                
                break;
            }
            
            // 작업
            if(!queue.isEmpty()) {
                Job job = queue.peek();
                
                if(t == (s + job.time)) {
                    queue.poll();
                    answer += (t - job.req);
                } else {
                    t++;
                    continue;
                }
            }
            
            if(queue.isEmpty()) {
                if(!diskController.isEmpty()) {
                    queue.add(diskController.poll());
                    s = t;
                } 
            }
            
            t++;
        }
        
        return answer / jobs.length;
    }
}