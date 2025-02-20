import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] dist;
    static ArrayList<Node> graph;

    static class Node implements Comparable<Node> {
        int from;
        int to;
        int w;

        Node(int from, int to, int w) {
            this.from = from;
            this.to = to;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.w, o.w);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer str;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        dist = new int[N+1];
        Arrays.fill(dist, -1);

        graph = new ArrayList<>();
        for(int i = 0; i < M; i++) {
            str = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());
            int c = Integer.parseInt(str.nextToken());

            graph.add(new Node(a, b, c));
        }

        Collections.sort(graph);

        sb.append(mst());
        
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    private static int mst() {
        int result = 0;
        int num = 0;
        for(int i = 0; i < graph.size(); i++) {
            if(num == N-1) {
                break;
            }
            Node now = graph.get(i);
            int from = now.from;
            int to = now.to;

            if(find(from) == find(to)) {
                continue;
            }

            union(from, to);
            result += now.w;
            num += 1;
        }

        return result;
    }

    private static void union(int from, int to) {
        from = find(from);
        to = find(to);

        if(from == to) {
            return;
        }

        if(dist[to] < dist[from]) {
            int tmp = from;
            from = to;
            to = tmp;
        }

        if(dist[from] == dist[to]) {
            dist[from]--;
        }

        dist[to] = from;
    }

    private static int find(int v) {
        if(dist[v] < 0) {
            return v;
        }

        return dist[v] = find(dist[v]);
    }

}