import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] dist;
    static int[][] map;
    static int[] dx = new int[] {0, 1, 0, -1};
    static int[] dy = new int[] {1, 0, -1, 0};
    static ArrayList<Node>[] graph;
    static int INF = Integer.MAX_VALUE;
    static class Node implements Comparable<Node> {
        int[] index;
        int cost;

        Node(int[] index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer str;

        map = new int[501][501];

        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            str = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(str.nextToken());
            int y1 = Integer.parseInt(str.nextToken());
            int x2 = Integer.parseInt(str.nextToken());
            int y2 = Integer.parseInt(str.nextToken());

            for(int x = Math.min(x1, x2); x <= Math.max(x1, x2); x++) {
                for(int y = Math.min(y1, y2); y <= Math.max(y1, y2); y++) {
                    map[x][y] = 1;
                }
            }
        }

        M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++) {
            str = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(str.nextToken());
            int y1 = Integer.parseInt(str.nextToken());
            int x2 = Integer.parseInt(str.nextToken());
            int y2 = Integer.parseInt(str.nextToken());

            for(int x = Math.min(x1, x2); x <= Math.max(x1, x2); x++) {
                for(int y = Math.min(y1, y2); y <= Math.max(y1, y2); y++) {
                    map[x][y] = 2;
                }
            }
        }

        graph = new ArrayList[501 * 501];
        for(int i = 0; i < 501*501; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i <= 500; i++) {
            for(int j = 0; j <= 500; j++) {
                // if(map[i][j] != 2) {

                    for(int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if(nx < 0 || ny < 0 || nx >= 501 || ny >= 501 || map[nx][ny] == 2) {
                            continue;
                        }

                        graph[i * 501 + j].add(new Node(new int[] {nx, ny}, map[nx][ny]));
                    }
                // }
            }
        }

        solve(0, 0);
        sb.append(dist[501*501-1] == INF ? -1 : dist[501*501-1]);

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }

    private static void solve(int i, int j) {
        dist = new int[501 * 501];
        Arrays.fill(dist, INF);

        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node (new int[] {i, j}, 0));
        dist[i*501+j] = 0;

        while(!q.isEmpty()) {
            Node now = q.poll();
            int nowXY = now.index[0] * 501 + now.index[1];


            if(now.cost > dist[nowXY]) {
                continue;
            }

            for(Node next : graph[nowXY]) {
                int nextXY = next.index[0] * 501 + next.index[1];
                if(dist[nextXY] > dist[nowXY] + next.cost) {
                    dist[nextXY] = dist[nowXY] + next.cost;
                    q.add(new Node(new int[] {next.index[0], next.index[1]}, dist[nextXY]));
                }

            }
        }
    }

}