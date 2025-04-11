import java.io.*;
import java.util.*;

public class Main {

	static final int INF = Integer.MAX_VALUE;
	static int N, M;
	static int[] dist;
	static int[][] map;
	static int[] dx = new int[] {0, 1, 0, -1};
	static int[] dy = new int[] {1, 0, -1, 0};
	static ArrayList<Node>[] graph;

	static class Node implements Comparable<Node> {
		int x, y, cost;

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

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer str;

		str = new StringTokenizer(br.readLine());
		M = Integer.parseInt(str.nextToken());
		N = Integer.parseInt(str.nextToken());

		graph = new ArrayList[N*M];
		for(int i = 0; i < N*M; i++) {
			graph[i] = new ArrayList<>();
		}

		map = new int[N][M];
		String s = "";
		for(int i = 0; i < N; i++) {
			s = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
			}
		}

		init();

		dijkstra(0, 0);

		bw.write(String.valueOf(dist[(N*M)-1]));
		bw.flush();
	}

	private static void dijkstra(int i, int j) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(i, j, 0));
		dist = new int[N*M];
		Arrays.fill(dist, INF);
		dist[(i*M) + j] = 0;

		while(!pq.isEmpty()) {
			Node now = pq.poll();

			if(now.x == N-1 && now.y == M-1) break;
			
			int index = (now.x * M) + now.y;
			for(Node next : graph[index]) {

				int ni = (next.x * M) + next.y;

				if(dist[ni] > next.cost + dist[index]) {
					dist[ni] = next.cost + dist[index];
					pq.add(new Node(next.x, next.y, dist[ni]));
				}
			}
		}
	}

	private static void init() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				for(int k = 0; k < 4; k++) {
					int nx = i + dx[k];
					int ny = j + dy[k];

					if(nx < 0 || ny < 0|| nx >= N || ny >= M) continue;

					if(map[nx][ny] == 0) {
						graph[(i * M) + j].add(new Node(nx, ny, 0));
						continue;
					}

					graph[(i * M) + j].add(new Node(nx, ny, 1));
				}
			}
		}
	}
}