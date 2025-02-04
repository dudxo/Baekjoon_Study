import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static long INF = Long.MAX_VALUE;
    static long[] dist;
    static boolean[] check;
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

        dist = new long[N];
        graph = new ArrayList[N];
        check = new boolean[N];

        for(int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        str = new StringTokenizer(br.readLine());
        String flag = "";
        for(int i = 0; i < N; i++) {
            flag = str.nextToken();
            if("1".equals(flag)) {
                check[i] = false;
                continue;
            }
            check[i] = true;
        }

        for(int i = 0; i < M; i++) {
            str = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(str.nextToken());
            int v = Integer.parseInt(str.nextToken());
            long w = Long.parseLong(str.nextToken());

            if(check[u] || u == N-1) {
                graph[u].add(new Node(v, w));
            }

            if(check[v] || v == N-1) {
                graph[v].add(new Node(u, w));
            }
        }

        dijkstra(0);

        if(dist[N-1] == INF) {
            sb.append("-1");
        } else {
            sb.append(dist[N-1]);
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