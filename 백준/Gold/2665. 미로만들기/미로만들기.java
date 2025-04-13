import java.io.*;
import java.util.*;

public class Main {

	static final int INF = Integer.MAX_VALUE;
	static int N;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int[] dist;
	static char[][] map;
	static ArrayList<Node>[] graph;

	static class Node implements Comparable<Node> {
		int index, cost;

		Node(int index, int cost) {
			this.index = index;
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

		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		for(int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		graph = new ArrayList[N*N];
		for(int i = 0; i < N*N; i++) {
			graph[i] = new ArrayList<>();
		}

		init();

		dijkstar(0, 0);

		sb.append(dist[(N * N) - 1]);

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static void dijkstar(int x, int y) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		dist = new int[N*N];
		Arrays.fill(dist, INF);

		pq.add(new Node((x * N) + y, 0));
		dist[(x * N) + y] = 0;

		while(!pq.isEmpty()) {
			Node now = pq.poll();

			for(Node next : graph[now.index]) {
				if(dist[next.index] > dist[now.index] + next.cost) {
					dist[next.index] = dist[now.index] + next.cost;
					pq.add(new Node(next.index, dist[next.index]));
				}
			}
		}
	}

	private static void init() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				for(int k = 0; k < 4; k++) {
					int nx = i + dx[k];
					int ny = j + dy[k];

					if(isRange(nx, ny)) {
						graph[(i * N) + j].add(new Node((nx * N) + ny, map[nx][ny] == '1' ? 0 : 1));
					}
				}
			}
		}
	}

	static boolean isRange(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < N;
	}

}