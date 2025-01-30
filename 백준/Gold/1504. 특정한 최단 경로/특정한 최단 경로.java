import java.io.*;
import java.util.*;

public class Main {

    static int N, E, v1, v2;
    static int[] dist;
    static boolean[] visited;
    static ArrayList<Node>[] graph;
    static int INF = 2_000_000;

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
        E = Integer.parseInt(str.nextToken());

        dist = new int[N + 1];
        visited = new boolean[N + 1];
        graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            str = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());
            int c = Integer.parseInt(str.nextToken());

            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }

        str = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(str.nextToken());
        v2 = Integer.parseInt(str.nextToken());

        int dist1 = dijstar(1, v1) + dijstar(v1, v2) + dijstar(v2, N);
        int dist2 = dijstar(1, v2) + dijstar(v2, v1) + dijstar(v1, N);

        if (dist1 >= INF && dist2 >= INF) {
            sb.append("-1");
        } else {
            sb.append(Math.min(dist1, dist2));
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    private static int dijstar(int start, int ed) {
        Arrays.fill(dist, INF);
        Arrays.fill(visited, false);
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(start, 0));
        dist[start] = 0;

        while(!q.isEmpty()) {
            Node now = q.poll();

            if(visited[ed]) {
                break;
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

        return dist[ed];
    }
}