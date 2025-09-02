import java.io.*;
import java.util.*;

public class Main {

	static int N, S, E;
	static ArrayList<Node>[] graph;

	static class Node implements Comparable<Node> {
		int index;
		int dist;

		Node(int index, int dist) {
			this.index = index;
			this.dist = dist;
		}

		@Override
		public int compareTo(Node o) {
			return this.dist - o.dist;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		StringTokenizer str;

		str = new StringTokenizer(br.readLine());
		N = Integer.parseInt(str.nextToken());
		S = Integer.parseInt(str.nextToken());
		E = Integer.parseInt(str.nextToken());

		graph = new ArrayList[N+1];
		for(int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		int s, e, d;
		for(int i = 1; i < N; i++) {
			str = new StringTokenizer(br.readLine());

			s = Integer.parseInt(str.nextToken());
			e = Integer.parseInt(str.nextToken());
			d = Integer.parseInt(str.nextToken());

			graph[s].add(new Node(e, d));
			graph[e].add(new Node(s, d));
		}

		sb.append(sol());

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static int sol() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		int[] dist = new int[N+1];
		int[] path = new int[N+1];
		int[] prevDist = new int[N+1];

		for(int i = 1; i <= N; i++) {
			dist[i] = Integer.MAX_VALUE;
		}

		pq.add(new Node(S, 0));
		dist[S] = 0;
		path[S] = S;

		while(!pq.isEmpty()) {
			Node now = pq.poll();

			for(Node next : graph[now.index]) {
				int newNextDist = next.dist + dist[now.index];

				if(dist[next.index] > newNextDist) {
					dist[next.index] = newNextDist;
					path[next.index] = now.index;
					prevDist[next.index] = next.dist;
					pq.add(new Node(next.index, newNextDist));
				}
			}
		}

		int maxDist = 0;
		for(int i = E; i != S; i = path[i]) {
			maxDist = Math.max(maxDist, prevDist[i]);
		}

		return dist[E] - maxDist;
	}
}

