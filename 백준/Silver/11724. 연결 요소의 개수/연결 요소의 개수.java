import java.io.*;
import java.util.*;


public class Main {

	static int[][] map;
	static boolean[] visited;
	static int N, M, cnt;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer str = new StringTokenizer(br.readLine());
		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());

		map = new int[N][N];
		visited = new boolean[N];

		cnt = 0;

		int p = 0, q = 0;

		for(int i = 0; i < M; i++) {
			str = new StringTokenizer(br.readLine());

			p = Integer.parseInt(str.nextToken());
			q = Integer.parseInt(str.nextToken());
			map[p-1][q-1] = 1;
			map[q-1][p-1] = 1;
		}

		for(int i = 0; i < N; i++) {
			if(!visited[i]) {
				cnt++;
				dfs(i);
			}
		}

		bw.write(String.valueOf(cnt));
		bw.flush();
		bw.close();
	}

	private static void dfs(int x) {
		visited[x] = true;

		for(int i = 0; i < N; i++) {
			if(map[x][i] == 0) continue;

			if(!visited[i]) {
				dfs(i);
			}
		}
	}

}