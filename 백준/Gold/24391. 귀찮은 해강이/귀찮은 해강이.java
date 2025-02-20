import java.io.*;
import java.util.*;

public class Main {

    static int N, M, result;
    static int[] graph, timetable;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer str;

        str = new StringTokenizer(br.readLine());

        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());

        graph = new int[N+1];
        timetable = new int[N+1];
        result = 0;
        Arrays.fill(graph, -1);

        for(int i = 0; i < M; i++) {
            str = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(str.nextToken());
            int to = Integer.parseInt(str.nextToken());

            union(from, to);
        }

        str = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            timetable[i] = Integer.parseInt(str.nextToken());
        }

        for(int i = 1; i < N; i++) {
            if(find(timetable[i]) != find(timetable[i+1])) {
                result += 1;
            }
        }

        sb.append(result);


        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    private static int find(int v) {
        if(graph[v] < 0) {
            return v;
        }

        return graph[v] = find(graph[v]);
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
}