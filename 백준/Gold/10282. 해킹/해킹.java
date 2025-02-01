import java.io.*;
import java.util.*;

public class Main {

    static int t, n, d, c, a, b, s, count, time;
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

        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            count = 0;
            time = Integer.MIN_VALUE;
            StringTokenizer str = new StringTokenizer(br.readLine());
            n = Integer.parseInt(str.nextToken());
            d = Integer.parseInt(str.nextToken());
            c = Integer.parseInt(str.nextToken());

            dist = new int[n+1];
            visited = new boolean[n+1];
            graph = new ArrayList[n+1];

            for(int i = 1; i <=n; i++) {
                graph[i] = new ArrayList<>();
            }

            for(int i = 0; i < d; i++) {
                str = new StringTokenizer(br.readLine());
                a = Integer.parseInt(str.nextToken());
                b = Integer.parseInt(str.nextToken());
                s = Integer.parseInt(str.nextToken());

                graph[b].add(new Node(a, s));
            }

            dijkstra(c);

            for(int i : dist) {
                if(i == INF) {
                    continue;
                }

                time = Math.max(i, time);
            }

            sb.append(count).append(" ").append(time).append("\n");
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

        while (!q.isEmpty()) {
            Node now = q.poll();

            if (!visited[now.index]) {
                visited[now.index] = true;
                count += 1;
            }

            for (Node next : graph[now.index]) {
                if (!visited[next.index] && dist[next.index] > dist[now.index] + next.cost) {
                    dist[next.index] = dist[now.index] + next.cost;
                    q.add(new Node(next.index, dist[next.index]));
                }
            }
        }
    }

}