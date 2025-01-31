import java.io.*;
import java.util.*;

public class Main {

    static int N, M, A, B;
    static long C, right, left;;
    static long[] dist;
    static boolean[] visited;
    static ArrayList<Node>[] graph;
    static int INF = 500_000;

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
        A = Integer.parseInt(str.nextToken());
        B = Integer.parseInt(str.nextToken());
        C = Long.parseLong(str.nextToken());

        dist = new long[N+1];
        visited = new boolean[N+1];
        graph = new ArrayList[N+1];

        for(int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        left = 0; right = Integer.MIN_VALUE;

        for(int i = 0; i < M; i++) {
            str = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(str.nextToken());
            int v = Integer.parseInt(str.nextToken());
            long w = Long.parseLong(str.nextToken());


            graph[u].add(new Node(v, w)); // 양방향
            graph[v].add(new Node(u, w));

            right = Math.max(right, w);  // 최대 간선 값
        }

        long result = INF;

        while(left <= right) {
            long mid = (left + right) / 2;

            if(dijkstra(mid) <= C) {
                result = mid;
                right = mid - 1;  // 현재 최대 간선치 mid로 갈 수 있기에 더 작은 최대 간선 비용 찾기
            } else {
                left = mid + 1;  // mid 간선치로 갈 수 없기에 최대 간선 mid를 줄여줌
            }
        }

        if(result == INF) {
            result = -1;
        }
        sb.append(result);

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    private static long dijkstra(long maxWeight) {
        Arrays.fill(dist, INF);
        Arrays.fill(visited, false);
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(A, 0));
        dist[A] = 0;

        while(!q.isEmpty()) {
            Node now = q.poll();

            if(now.cost > dist[now.index]) {
                continue;
            }

            if(!visited[now.index]) {
                visited[now.index] = true;
            }

            for(Node next : graph[now.index]) {

                if(next.cost > maxWeight) { // 최대 간선 값 보다 크면 넘어감
                    continue;
                }

                if(dist[next.index] > dist[now.index] + next.cost) {
                    dist[next.index] = dist[now.index] + next.cost;
                    q.add(new Node(next.index, dist[next.index]));
                }
            }
        }

        return dist[B];
    }

}