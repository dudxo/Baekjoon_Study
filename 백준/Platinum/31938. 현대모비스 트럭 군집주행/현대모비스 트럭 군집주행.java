import java.io.*;
import java.util.*;

public class Main {

    static final long INF = Long.MAX_VALUE;
    static int N, M;
    static long[] dist1, dist2, dist3;
    static int[] path;
    static ArrayList<Node>[] graph;
    static ArrayList<Path> paths;
    static class Node implements Comparable<Node> {
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

    static class Path implements Comparable<Path> {
        int index;
        int last;

        Path(int index, int last) {
            this.index = index;
            this.last = last;
        }

        @Override
        public int compareTo(Path o) {
            if(this.last == o.last) return Integer.compare(this.index, o.index); // TODO Path 다시 만들기

            return Integer.compare(this.last, o.last);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str;

        str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());

        graph = new ArrayList[N+1];
        dist1 = new long[N+1];  // 최단 경로(실제 그냥 비용 누적 값)
        dist2 = new long[N+1];  // 할인 값
        dist3 = new long[N+1];  // 이동한 순수값 (x->y로)
        path = new int[N+1];

        for(int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        int a = 0, b = 0, c = 0, tmp = 0;
        for(int i = 0; i < M; i++) {
            str = new StringTokenizer(br.readLine());

            a = Integer.parseInt(str.nextToken());
            b = Integer.parseInt(str.nextToken());
            c = Integer.parseInt(str.nextToken());

            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }

        dijkstra(1);

        paths = new ArrayList<>();
        for(int i = 2; i <= N; i++) {
            paths.add(new Path(i, path[i]));
        }

        Collections.sort(paths);
        long result = 0;
        int size = paths.size();
        for(int i = 0; i < size; i++) {
            Path p = paths.get(i);
            int index = p.index;
            int last = p.last;

            if(last == 1) {
                result += dist3[index];
                continue;
            }

            result += dist2[last] + dist3[index];
        }


        bw.write(String.valueOf(result));
        bw.flush();
        br.close();
        bw.close();
    }

    private static void dijkstra(int st) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Arrays.fill(dist1, INF);
        Arrays.fill(dist2, INF);
        Arrays.fill(dist3, INF);
        pq.add(new Node(st, 0));
        dist1[st] = 0;
        dist2[st] = 0;
        dist3[st] = 0;

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if(dist1[now.index] < now.cost) continue;

            for(Node next : graph[now.index]) {
                if(next.index == 1) continue;


                long newCost1 = next.cost + dist1[now.index];
                long nc = next.cost;
                long newDiscount = (long)(nc*0.9) + dist2[now.index];

                if(dist1[next.index] > newCost1) {
                   dist1[next.index] = newCost1;
                    dist3[next.index] = nc;

                   // if(dist2[next.index] > newDiscount) {
                       dist2[next.index] = newDiscount;
                   // }

                   if(dist1[next.index] == newCost1)
                   pq.add(new Node(next.index, newCost1));
                   path[next.index] = now.index;
                }

                if(dist1[next.index] == newCost1 /*&& dist2[next.index] > newDiscount*/) {
                    dist3[next.index] = nc;
                    dist2[next.index] = newDiscount;
                    path[next.index] = now.index;
                }

            }
        }
    }

}