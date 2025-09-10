import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer str;

		str = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(str.nextToken());
		int q = Integer.parseInt(str.nextToken());
		int ans = sol(p, q);

		bw.write(String.valueOf(ans));
		bw.flush();
		bw.close();
	}

	private static int sol(int p, int q) {
		if(p == q) return 0;

		ArrayDeque<Integer> dq = new ArrayDeque<>();
		boolean[] visited = new boolean[100001];

		dq.add(p);
		visited[p] = true;

		int size = 0, cnt = 0;

		while(true) {
			size = dq.size();
			cnt++;
			for(int i = 0; i < size; i++) {
				int now = dq.poll();

				if(now == q) return cnt - 1;

				if(now-1 >= 0 && !visited[now-1]) {
					visited[now-1] = true;
					dq.add(now-1);
				}
				if(now+1 <= 100000 && !visited[now+1]) {
					visited[now+1] = true;
					dq.add(now+1);
				}
				if(now*2 <= 100000 && !visited[now*2]) {
					visited[now*2] = true;
					dq.add(now*2);
				}
			}
		}
	}
}

