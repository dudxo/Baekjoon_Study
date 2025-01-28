import java.io.*;
import java.util.*;

public class Main {

    static int N, M, K, X;
    static int INF = Integer.MAX_VALUE;
    static int[] dist;
    static boolean[] visited;
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
        M = Integer.parseInt(str.nextToken());
        K = Integer.parseInt(str.nextToken());
        X = Integer.parseInt(str.nextToken());

        graph = new ArrayList[N+1];
        dist = new int[N+1];
        visited = new boolean[N+1];

        for(int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = INF;
        }

        for(int i = 0; i < M; i++) {
            str = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(str.nextToken());
            int v = Integer.parseInt(str.nextToken());

            graph[u].add(new Node(v, 1));
        }

        dijstra(X);

        for(int i = 1; i <= N; i++) {
            if(dist[i] == K) {
                sb.append(i).append("\n");
            }
        }

        if(sb.length() == 0) {
            sb.append(-1);
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    private static void dijstra(int start) {
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(start, 0));

        dist[start] = 0;

        while(!q.isEmpty()) {
            Node now = q.poll();

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