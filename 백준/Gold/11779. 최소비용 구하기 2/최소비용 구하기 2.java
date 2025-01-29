import java.io.*;
import java.util.*;

public class Main {

    static int n, m, st, ed;
    static int[] dist, path;
    static boolean[] visited;
    static int INF = Integer.MAX_VALUE;
    static ArrayList<Node>[] graph;
    static ArrayList<Integer> result;

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

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        graph = new ArrayList[n+1];
        dist = new int[n+1];
        path = new int[n+1];
        visited = new boolean[n+1];
        result = new ArrayList<>();

        for(int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = INF;
        }

        StringTokenizer str;
        for(int i = 0; i < m; i++) {
            str = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(str.nextToken());
            int v = Integer.parseInt(str.nextToken());
            int w = Integer.parseInt(str.nextToken());
            graph[u].add(new Node(v, w));
        }

        str = new StringTokenizer(br.readLine());
        st = Integer.parseInt(str.nextToken());
        ed = Integer.parseInt(str.nextToken());

        dijstra(st, ed);

        int cur = ed;
        while(cur != st) {
            result.add(cur);
            cur = path[cur];
        }
        result.add(st);


        Collections.reverse(result);
        sb.append(dist[ed]).append("\n").append(result.size()).append("\n");

        for(int i : result) {
            sb.append(i).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    private static void dijstra(int st, int ed) {
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(st, 0));
        dist[st] = 0;
        path[st] = st;

        while(!q.isEmpty()) {
            Node now = q.poll();

            if(!visited[now.index]) {
                visited[now.index] = true;
            }

            if(visited[ed]) {
                break;
            }

            for(Node next : graph[now.index]) {
                if(!visited[next.index] && dist[next.index] > dist[now.index] + next.cost) {
                    dist[next.index] = dist[now.index] + next.cost;
                    q.add(new Node(next.index, dist[next.index]));
                    path[next.index] = now.index;
                }
            }
        }
    }

}