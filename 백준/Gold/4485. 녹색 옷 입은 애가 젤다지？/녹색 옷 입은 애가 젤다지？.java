import java.io.*;
import java.util.*;

public class Main {

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

    static final String PREFIX = "Problem ";
    static int N;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] map;
    static int[][] dist;
    static int INF = Integer.MAX_VALUE;

    static class Node implements Comparable<Node> {
        int x;
        int y;
        int cost;

        Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int count = 1;
        while(true) {
            N = read();
            if(N == 0) {
                break;
            }

            map = new int[N][N];
            dist = new int[N][N];

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    map[i][j] = read();
                    Arrays.fill(dist[i], INF);
                }
            }

            dijkstra(0, 0);
            sb.append(PREFIX).append(count++).append(": ").append(dist[N-1][N-1]).append("\n");
        }
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void dijkstra(int i, int j) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(i, j, map[i][j]));
        boolean[][] visited = new boolean[N][N];
        dist[i][j] = map[i][j];

        while(!pq.isEmpty()) {
            Node now = pq.poll();
            int x = now.x;
            int y = now.y;

            if(!visited[x][y]) {
                visited[x][y] = true;
            }

            if(x == N-1 && y == N-1) {
                return;
            }

            for(int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if(nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny]) {
                    continue;
                }

                if(dist[nx][ny] > dist[x][y] + map[nx][ny]) {
                    dist[nx][ny] = dist[x][y] + map[nx][ny];
                    pq.add(new Node(nx, ny, dist[nx][ny]));
                }
            }
        }

    }
}