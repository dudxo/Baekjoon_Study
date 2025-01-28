import java.io.*;
import java.util.*;

public class Main {

    static int V, E, K;
    static ArrayList<Node>[] graph;
    static boolean[] check;
    static int[] dist;
    static int INF = Integer.MAX_VALUE;

    public static class Node implements Comparable<Node>{
        int cost;
        int index;

        Node() {}
        Node(int cost, int index) {
          this.cost = cost;
          this.index = index;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer str = new StringTokenizer(br.readLine());
        V = Integer.parseInt(str.nextToken());
        E = Integer.parseInt(str.nextToken());
        K = Integer.parseInt(br.readLine());

        graph = new ArrayList[V + 1];
        check = new boolean[V + 1];
        dist = new int[V + 1];

        for(int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();  // 그래프 초기화
            dist[i] = INF;  // 최단 거리 테이블 무한대 초기화
        }

        for(int i = 1; i <= E; i++) {
            str = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(str.nextToken());
            int v = Integer.parseInt(str.nextToken());
            int w = Integer.parseInt(str.nextToken());

            graph[u].add(new Node(w, v));
        }

        dijkstra(K);

        for(int i = 1; i <= V; i++) {
            if(dist[i] == INF) {
                sb.append("INF").append("\n");
                continue;
            }
            sb.append(dist[i]).append("\n");
        }


        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(0, start));
        dist[start] = 0;

        while(!q.isEmpty()) {
            Node now = q.poll();

            if(!check[now.index]) {
                check[now.index] = true;
            }

            for(Node next : graph[now.index]) {
                if(!check[next.index] && dist[next.index] > dist[now.index] + next.cost) {
                    dist[next.index] = dist[now.index] + next.cost;
                    q.add(new Node(dist[next.index], next.index));
                }
            }
        }
    }

}