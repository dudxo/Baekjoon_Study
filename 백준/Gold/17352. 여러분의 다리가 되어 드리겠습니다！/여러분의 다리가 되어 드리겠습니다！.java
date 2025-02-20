import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer str;

        N = Integer.parseInt(br.readLine());

        graph = new int[N+1];
        Arrays.fill(graph, -1);
        for(int i = 0; i < N-2; i++) {
            str = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(str.nextToken());
            int to = Integer.parseInt(str.nextToken());

            union(from, to);
        }

        int land = find(1);
        for(int i = 1; i <= N; i++) {
            if(land != find(i)) {
                sb.append(find(i)).append(" ").append(land);
                break;
            }
        }


        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    private static void union(int from, int to) {
        from = find(from);
        to = find(to);

        if(from == to) {
            return;
        }

        if(graph[to] < graph[from]) {
            int tmp = from;
            from = to;
            to = tmp;
        }

        if(graph[from] == graph[to]) {
            graph[from]--;
        }

        graph[to] = from;
    }

    private static int find(int v) {
        if(graph[v] < 0) {
            return v;
        }

        return graph[v] = find(graph[v]);
    }
}