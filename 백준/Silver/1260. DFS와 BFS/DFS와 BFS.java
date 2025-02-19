import java.io.*;
import java.util.*;

public class Main {

    static int N, M, V;
    static boolean[] visited;
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer str;

        str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());
        V = Integer.parseInt(str.nextToken());

        graph = new ArrayList[N+1];

        for(int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            str = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(str.nextToken());
            int v = Integer.parseInt(str.nextToken());

            // 양방향
            graph[u].add(v);
            graph[v].add(u);
        }

        for(int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        visited = new boolean[N+1];
        dfs(V, sb);

        sb.append("\n");

        visited = new boolean[N+1];
        bfs(V, sb);

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    private static void bfs(int v, StringBuilder sb) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(v);
        visited[v] = true;

        while(!q.isEmpty()) {
            int now = q.poll();
            sb.append(now).append(" ");

            for(int i : graph[now]) {
                if(!visited[i]) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }

    private static void dfs(int v, StringBuilder sb) {
        visited[v] = true;
        sb.append(v).append(" ");

        for(int i : graph[v]) {
            if(!visited[i]) {
                dfs(i, sb);
            }
        }
    }


}