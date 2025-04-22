import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[] dist;
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
		StringTokenizer str;

		str = new StringTokenizer(br.readLine());
		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());

		graph = new ArrayList[N+1];
		for(int i = 0; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		for(int i = 0; i < N-1; i++) {
			str = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(str.nextToken());
			int v = Integer.parseInt(str.nextToken());
			int cost = Integer.parseInt(str.nextToken());

			graph[u].add(new Node(v, cost));
			graph[v].add(new Node(u, cost));
		}

		for(int i = 0; i < M; i++) {
			str = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(str.nextToken());
			int v = Integer.parseInt(str.nextToken());

			dijkstra(u);

			sb.append(dist[v]).append("\n");
		}



		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static void dijkstra(int st) {
		Queue<Node> q = new ArrayDeque<>();
		dist = new int[N+1];
		for(int i = 0; i <= N; i++) {
			dist[i] = Integer.MAX_VALUE;
		}

		q.add(new Node(st, 0));
		dist[st] = 0;

		while(!q.isEmpty()) {
			Node now = q.poll();

			for(Node next : graph[now.index]) {
				int newCost = next.cost + dist[now.index];

				if(dist[next.index] > newCost) {
					dist[next.index] = newCost;
					q.add(new Node(next.index, newCost));
				}
			}
		}
	}

}
