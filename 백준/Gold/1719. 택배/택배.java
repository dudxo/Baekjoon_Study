import java.io.*;
import java.util.*;

public class Main {

    static final int INF = Integer.MAX_VALUE;
    static int N, M;
    static int[] dist, path;
    static ArrayList<Node>[] graph;
    static PriorityQueue<Node> pq = new PriorityQueue<>();

    static class Node implements Comparable<Node> {
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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer str;

        str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());

        graph = new ArrayList[N+1];
        dist = new int[N+1];
        path = new int[N+1];
        
        for(int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        int u = 0, v = 0, c = 0;
        for(int i = 0; i < M; i++) {
            str = new StringTokenizer(br.readLine());
            u = Integer.parseInt(str.nextToken());
            v = Integer.parseInt(str.nextToken());
            c = Integer.parseInt(str.nextToken());

            graph[u].add(new Node(v, c));
            graph[v].add(new Node(u, c));
        }

        int j;
        for(int i  = 1; i <= N; i++) {
            dijkstra(i);

            for(j = 1; j <= N; j++) {
                if(i == j) continue;
                sol(j);
            }

            for(j = 1; j <= N; j++) {
               if(i == j) sb.append("- ");
               else sb.append(path[j]).append(j == N ? "\n" : " ");
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static int sol(int i) {
        if(path[i] == i) {
            return i;
        }

        return path[i] = sol(path[i]);
    }

    private static void dijkstra(int st) {
        Arrays.fill(dist, INF);
        pq.clear();
        pq.add(new Node(st, 0));
        dist[st] = 0;
        path[st] = 0;

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if(dist[now.index] < now.cost) continue;

            for(Node next : graph[now.index]) {
                int newCost = dist[now.index] + next.cost;

                if(dist[next.index] > newCost) {
                    dist[next.index] = newCost;
                    pq.add(new Node(next.index, newCost));

                    if(now.index == st) path[next.index] = next.index;
                    else path[next.index] = now.index;
                }
            }
        }
    }
}