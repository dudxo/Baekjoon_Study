import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static boolean[] visited;
    static int[][] arr;
    static int node, line, start;
    static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        node = Integer.parseInt(st.nextToken());
        line = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        arr = new int[node+1][node+1];
        visited = new boolean[node+1];

        for (int i = 0; i < line; i++) {        // 간선의 수 만큼 반복하여 각 노드 연결
            StringTokenizer str = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());

            arr[a][b] = arr[b][a] = 1;
        }

        DFS(start);
        visited = new boolean[node+1];
        System.out.println();
        BFS(start);

    }

    static void DFS(int start) {
        visited[start] = true;
        System.out.printf(start + " ");

        for (int i = 0; i <= node; i++) {
            if(arr[start][i] == 1 && !visited[i])
                DFS(i);
        }
    }

    static void BFS(int start) {
        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            start = q.poll();
            System.out.printf(start + " ");
            for (int i = 1; i <= node; i++) {
                if (arr[start][i] == 1 && !visited[i]) {
                    q.offer(i);
                    visited[i]=true;
                }
            }
        }
    }

}
