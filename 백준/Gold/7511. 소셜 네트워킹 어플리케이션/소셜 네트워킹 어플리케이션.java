import java.io.*;
import java.util.*;

public class Main {

    static final String PREFIX = "Scenario ";
    static int T, N, M, K, testNum;
    static int[] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer str;

        T = Integer.parseInt(br.readLine());

        testNum = 1;
        while(T-- > 0) {
            N = Integer.parseInt(br.readLine());
            K = Integer.parseInt(br.readLine());

            graph = new int[N];
            Arrays.fill(graph, -1);

            for(int i = 0; i < K; i++) {
                str = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(str.nextToken());
                int b = Integer.parseInt(str.nextToken());
                union(a, b);
            }

            M = Integer.parseInt(br.readLine());

            sb.append(PREFIX).append(testNum++).append(":");

            for(int i = 0; i < M; i++) {
                str = new StringTokenizer(br.readLine());

                int u = Integer.parseInt(str.nextToken());
                int v = Integer.parseInt(str.nextToken());

                if(find(u) == find(v)) {
                    sb.append("\n1");
                    continue;
                }

                sb.append("\n0");
            }

            sb.append("\n\n");

        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    private static void union(int a, int b) {
        a = find(a);
        b=  find(b);

        if(a == b) {
            return;
        }

        if(graph[b] < graph[a]) {
            int tmp = a;
            a = b;
            b = tmp;
        }

        if(graph[a] == graph[b]) {
            graph[a]--;
        }

        graph[b] = a;
    }

    private static int find(int v) {
        if(graph[v] < 0) {
            return v;
        }
        return graph[v] = find(graph[v]);
    }

}