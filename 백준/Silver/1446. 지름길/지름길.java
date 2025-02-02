import java.io.*;
import java.util.*;

public class Main {

    static int N, D;
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
        N = Integer.parseInt(str.nextToken());
        D = Integer.parseInt(str.nextToken());

        dist = new int[D+1];
        graph = new ArrayList[D+1];

        for(int i = 0; i <= D; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < D; i++) {
            graph[i].add(new Node(i+1, 1));
        }

        for(int i = 0; i < N; i++) {
            str = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(str.nextToken());
            int v = Integer.parseInt(str.nextToken());
            int w = Integer.parseInt(str.nextToken());

            if(v > D ) {
                continue;
            }

            graph[u].add(new Node(v, w));
        }

        dijkstra(0);

        sb.append(dist[D]);

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    private static void dijkstra(int st) {
        Arrays.fill(dist, INF);
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(st, 0));
        dist[st] = 0;

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