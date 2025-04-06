import java.io.*;
import java.util.*;

public class Main {

	static int N, L, result;
	static Queue<Node> queue;

	static class Node {
		int d, r, g;

		Node(int d, int r, int g) {
			this.d = d;
			this.r = r;
			this.g = g;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer str;

		str = new StringTokenizer(br.readLine());
		N = Integer.parseInt(str.nextToken());
		L = Integer.parseInt(str.nextToken());
		queue = new ArrayDeque<>();

		for (int i = 0; i < N; i++) {
			str = new StringTokenizer(br.readLine());
			queue.add(new Node(
				Integer.parseInt(str.nextToken()),
				Integer.parseInt(str.nextToken()),
				Integer.parseInt(str.nextToken())
			));
		}

		result = sol();

		bw.write(String.valueOf(result));
		bw.flush();
	}

	private static int sol() {
		int time = 0, road = 0;
		while(road < L) {
			time++;
			if(!queue.isEmpty() && road == queue.peek().d) {
				Node now = queue.poll();
				int cycle = now.r + now.g;
				int remain = time % cycle;

				if (remain > 0 && remain <= now.r) {
					time += (now.r - remain + 1);
				}

			}
			road++;
		}

		return time;
	}

}