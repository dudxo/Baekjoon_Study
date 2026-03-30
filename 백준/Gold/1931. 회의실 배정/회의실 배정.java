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

		int s1 = 0, e1 = 0, cnt = 1;
		int startTime = pq.peek().s, lastTime = pq.peek().e;
		pq.poll();

		// if(!pq.isEmpty()) {
		// 	Node node = pq.peek();
		//
		// 	// 빌리는 시간이 같으면
		// 	if(lastTime - startTime == node.e - node.s) {
		// 		// 더 빨리 끝나는 시간을 픽
		// 		if(lastTime >= node.e) {
		// 			lastTime = node.e;
		// 		}
		// 	}
		// 	else if(lastTime - startTime > node.e - node.s) {
		//
		// 	}
		// }

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