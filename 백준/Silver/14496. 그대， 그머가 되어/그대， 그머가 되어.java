import java.io.*;
import java.util.*;

public class Main {

    static int a, b, N, M;
    static int INF = Integer.MAX_VALUE;
    static int[] dist;
    static ArrayList<Node>[] graph;
    public static class Node implements Comparable<Node> {
        int index;
        int cost;

        Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
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
        a = Integer.parseInt(str.nextToken());
        b = Integer.parseInt(str.nextToken());

        str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());

        dist = new int[N+1];
        graph = new ArrayList[N+1];
        for(int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            str = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(str.nextToken());
            int v = Integer.parseInt(str.nextToken());

            graph[u].add(new Node(v, 1));
            graph[v].add(new Node(u, 1));
        }

        dijkstra(a);

        if(dist[b] == INF) {
            sb.append("-1");
        } else {
            sb.append(dist[b]);
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    private static void dijkstra(int start) {
        Arrays.fill(dist, INF);
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(start, 0));
        dist[start] = 0;

        while(!q.isEmpty()) {
            Node now = q.poll();

            if(now.cost > dist[now.index]) {
                continue;
            }

            for(Node next : graph[now.index]) {
                if(dist[next.index] > dist[now.index] + next.cost) {
                    dist[next.index] = dist[now.index] + next.cost;
                    q.add(new Node(next.index, dist[next.index]));
                }
            }
        }
    }

}