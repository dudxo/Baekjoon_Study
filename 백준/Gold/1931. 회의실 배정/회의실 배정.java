import java.io.*;
import java.util.*;


public class Main {


	static class Node implements Comparable<Node> {
		int s, e;

		Node(int s, int e) {
			this.s = s;
			this.e = e;
		}

		@Override
		public int compareTo(Node o) {
			if(this.e == o.e) {
				return Integer.compare(this.s, o.s);
			}

			return Integer.compare(this.e, o.e);
		}
	}

	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer str;
		N = Integer.parseInt(br.readLine());
		PriorityQueue<Node> pq = new PriorityQueue<>();

		for(int i = 0; i < N; i++) {
			str = new StringTokenizer(br.readLine());

			pq.add(new Node(Integer.parseInt(str.nextToken()), Integer.parseInt(str.nextToken())));
		}

		int s1 = 0, e1 = 0, cnt = 1, lastTime = pq.poll().e;

		while(!pq.isEmpty()) {
			Node next = pq.poll();
			s1 = next.s;
			e1 = next.e;

			if(lastTime <= s1) {
				cnt++;
				lastTime = e1;
			}
		}

		bw.write(String.valueOf(cnt));

		bw.flush();
		bw.close();
	}

}