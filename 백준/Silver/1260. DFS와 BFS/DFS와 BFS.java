import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<Integer>[] node;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(str.nextToken());
        int M = Integer.parseInt(str.nextToken());
        int V = Integer.parseInt(str.nextToken());
        node = new ArrayList[N+1];
        visited = new boolean[N+1];

        for(int i = 1; i < N+1; i++){
            node[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i < M; i++){
            str = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(str.nextToken());
            int e = Integer.parseInt(str.nextToken());

            node[s].add(e);
            node[e].add(s);
        }

        for(int i = 1; i < N+1; i++){
            Collections.sort(node[i]);
        }

        DFS(V);
        sb.append("\n");
        visited = new boolean[N+1];
        BFS(V);
        System.out.println(sb);
    }

    public static void DFS(int i) {
        if(visited[i]){
            return;
        }
        sb.append(i + " ");
        visited[i] = true;
        for(int u : node[i]){
            if(!visited[u]){
                DFS(u);
            }
        }
    }

    public static void BFS(int i){
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        visited[i] = true;

        while (!q.isEmpty()) {
            int u = q.poll();
            sb.append(u + " ");
            for(int j : node[u]){
                if(!visited[j]){
                    q.offer(j);
                    visited[j] = true;
                }
            }
        }
    }
}