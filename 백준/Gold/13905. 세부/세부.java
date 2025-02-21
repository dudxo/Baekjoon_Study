import java.io.*;
import java.util.*;

public class Main {

    static int N, M, s, e, result;
    static int[] dist;
    static ArrayList<Node> graph;
    static ArrayList<int[]> mst;
    static ArrayList<ArrayList<int[]>> lists;

    static class Node implements Comparable<Node> {
        int u;
        int v;
        int w;

        Node(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(o.w, this.w);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer str;

        str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());

        graph = new ArrayList<>();
        mst  = new ArrayList<>();
        lists  = new ArrayList<>();
        for(int i = 0; i <= N; i++) {
            lists.add(new ArrayList<>());
        }
        dist = new int[N+1];
        Arrays.fill(dist, -1);

        str = new StringTokenizer(br.readLine());
        s = Integer.parseInt(str.nextToken());
        e = Integer.parseInt(str.nextToken());

        for(int i = 0; i < M; i++) {
            str = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(str.nextToken());
            int v = Integer.parseInt(str.nextToken());
            int w = Integer.parseInt(str.nextToken());

            graph.add(new Node(u, v, w));
        }

        Collections.sort(graph);

        for(Node node : graph) {
            if(mst.size() == N-1) {
                break;
            }
            mst(node);
        }

        result = Integer.MAX_VALUE;

        for(int[] iArr : mst) {
            lists.get(iArr[0]).add(new int[] {iArr[1], iArr[2]});
            lists.get(iArr[1]).add(new int[] {iArr[0], iArr[2]});
        }

        sb.append(bfs(s, e));

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    private static int bfs(int st, int ed) {
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[N+1];
        q.add(new int[] {st, Integer.MAX_VALUE});

        visited[st] = true;

        while(!q.isEmpty()) {
            int[] now = q.poll();

            if(now[0] == ed) {
                return now[1];
            }

            for(int[] arr : lists.get(now[0])) {
                if(!visited[arr[0]]) {
                    visited[arr[0]] = true;
                    q.add(new int[] {arr[0], Math.min(now[1], arr[1])});
                }
            }
        }

        return 0;
    }

    private static void mst(Node now) {
        int u = now.u;
        int v = now.v;
        int w = now.w;

        if (find(u) == find(v)) {
            return;
        }

        if (union(u, v)) {
            mst.add(new int[] {u, v, w});
        }
    }

    private static int find(int v) {
        if(dist[v] < 0) {
            return v;
        }

        return dist[v] = find(dist[v]);
    }

    private static boolean union(int u, int v) {
        u = find(u);
        v = find(v);

        if(u == v) {
            return false;
        }

        if(dist[v] < dist[u]) {
            int tmp = u;
            u = v;
            v = tmp;
        }

        if(dist[u] == dist[v]) {
            dist[u]--;
        }

        dist[v] = u;

        return true;
    }
}