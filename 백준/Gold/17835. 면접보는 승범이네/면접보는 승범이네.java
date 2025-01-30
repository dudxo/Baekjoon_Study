import java.io.*;
import java.util.*;

public class Main {

    static int N, M, K;
    static long[] dist;
    static boolean[] visited;
    static long INF = Long.MAX_VALUE;
    static ArrayList<Node>[] graph;

    public static class Node implements Comparable<Node> {
        int index;
        long cost;

        Node(int index, long cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.cost, o.cost);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());
        K = Integer.parseInt(str.nextToken());

        dist = new long[N+1];
        visited = new boolean[N+1];
        graph = new ArrayList[N+1];

        for(int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        Arrays.fill(dist, INF);
        Arrays.fill(visited, false);

        for(int i = 0; i < M; i++) {
            str = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(str.nextToken());
            int v = Integer.parseInt(str.nextToken());
            int c = Integer.parseInt(str.nextToken());

            graph[v].add(new Node(u, c));
        }
        PriorityQueue<Node> q = new PriorityQueue<>();
        str = new StringTokenizer(br.readLine());
        for(int i = 0; i < K; i++) {
            int interview = Integer.parseInt(str.nextToken());
            dist[interview] = 0;
            q.add(new Node(interview, 0));
        }

        dijkstra(q);

        long maxCost = Integer.MIN_VALUE;
        int maxCity = 0;
        for(int i = 1; i <= N; i++) {
            if(dist[i] != INF && dist[i] > maxCost) {
                maxCost = dist[i];
                maxCity = i;
            }
        }

        sb.append(maxCity).append("\n").append(maxCost);

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    public static void dijkstra(PriorityQueue<Node> q) {
        while(!q.isEmpty()) {
            Node now = q.poll();

            if(now.cost > dist[now.index] || visited[now.index]) {
                continue;
            }

            if(!visited[now.index]) {
                visited[now.index] = true;
            }

            for(Node next : graph[now.index]) {
                if(!visited[next.index] && dist[next.index] > dist[now.index] + next.cost) {
                    dist[next.index] = dist[now.index] + next.cost;
                    q.add(new Node(next.index, dist[next.index]));
                }
            }
        }
    }

}