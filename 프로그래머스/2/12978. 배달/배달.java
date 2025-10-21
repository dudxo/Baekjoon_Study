import java.util.*;

class Solution {
    
    static ArrayList<Node>[] graph;
    static int n, k, answer;
    static int INF = Integer.MAX_VALUE;
    
    static class Node implements Comparable<Node> {
        int index, cost;
        
        Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
    
    public int solution(int N, int[][] road, int K) {
        answer = 0;
        n = N;
        k = K;
        
        int u, v, c;
        graph = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < road.length; i++) {
            int[] r = road[i];
            u = r[0];
            v = r[1];
            c = r[2];
            
            graph[u].add(new Node(v, c));
            graph[v].add(new Node(u, c));
        }
        
        sol(1);

        return answer;
    }
    
    private static void sol(int s) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(s, 0));
        int[] dist = new int[n+1];
        
        Arrays.fill(dist, INF);        
        dist[s] = 0;
        
        while(!pq.isEmpty()) {
            Node now = pq.poll();
            
            for(Node next : graph[now.index]) {
                if(dist[next.index] > dist[now.index] + next.cost) {
                    dist[next.index] = dist[now.index] + next.cost;
                    pq.add(new Node(next.index, dist[next.index]));
                }
            }
        }
        
        for(int i : dist) {
            if(i <= k) answer++;
        }
    }
}