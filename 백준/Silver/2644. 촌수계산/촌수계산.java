import java.io.*;
import java.util.*;

public class Main {

	static int N, P, Q, M;
	static ArrayList<Integer>[] families;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());

		families = new ArrayList[N+1];
		for(int i = 1; i <= N; i++) {
			families[i] = new ArrayList<>();
		}

		StringTokenizer str;
		str = new StringTokenizer(br.readLine());
		P = Integer.parseInt(str.nextToken());
		Q = Integer.parseInt(str.nextToken());

		M = Integer.parseInt(br.readLine());

		int x, y;
		while(M-- > 0) {
			str = new StringTokenizer(br.readLine());

			x = Integer.parseInt(str.nextToken());
			y = Integer.parseInt(str.nextToken());

			families[x].add(y);
			families[y].add(x);
		}

		sb.append(sol());

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static int sol() {
		ArrayDeque<int[]> dq = new ArrayDeque<>();
		boolean[] visited = new boolean[N+1];
		dq.add(new int[] {P, 0});
		visited[P] = true;

		int cnt = 0;

		while(!dq.isEmpty()) {
			int size = dq.size();
			
			while(size-- > 0) {
				int[] current = dq.poll();

				if(current[0] == Q) return current[1];

				for(int i : families[current[0]]) {
					if(!visited[i]) {
						visited[i] = true;
						dq.add(new int[] {i, current[1] + 1});
					}
				}
			}
		}

		return -1;
	}

}

