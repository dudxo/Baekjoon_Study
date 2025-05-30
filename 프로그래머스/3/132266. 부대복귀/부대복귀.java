import java.util.*;
import java.lang.*;

class Solution {
    
    static ArrayList<Node>[] graph;
    static int INF = Integer.MAX_VALUE;
    static int[] dist;
    
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
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        graph = new ArrayList[n+1];
        
        for(int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < roads.length; i++) {
            int u = roads[i][0];
            int v = roads[i][1];
            
            graph[u].add(new Node(v, 1));
            graph[v].add(new Node(u, 1));
        }
        
//         for(int i = 0; i < sources.length; i++) {
//             int result = dijkstar(sources[i], n, destination);
//             if(result == INF) {
//                 result = -1;
//             }
//             answer[i] = result;
//         }
        
        

            dijkstar(destination, n);
            
            // int j = 0;
            // for(int d : dist) {
            //     System.out.printf("%d번의 비용 = %d\n", j, d);
            //     j++;
            // }
                
            for(int i = 0; i < sources.length; i++) {
                if(dist[sources[i]] == INF) {
                    dist[sources[i]] = -1;
                }
                answer[i] = dist[sources[i]];
            }
        
        
        
        return answer;
    }
    
    private static void dijkstar(int s, int n) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist = new int[n+1];
        
        for(int i = 1; i <= n; i++) {
            dist[i] = INF;
        }
        
        pq.add(new Node(s, 0));
        dist[s] = 0;
        
        while(!pq.isEmpty()) {
            Node now = pq.poll();
            
            for(Node next : graph[now.index]) {
                int newDist = next.cost + dist[now.index];
                
                if(dist[next.index] > newDist) {
                    dist[next.index] = newDist;
                    pq.add(new Node(next.index, newDist));
                }
            }
        }
    }
}