import java.io.*;
import java.util.*;


public class Main {

	static char[][] map;
	static boolean[][] visited;
	static int N, M, cnt;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());

		map = new char[N][N];
		visited = new boolean[N][N];

		cnt = 0;

		int p = 0, q = 0;
		String s = "";

		for(int i = 0; i < N; i++) {
			s = br.readLine();
			map[i] = s.toCharArray();
		}

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for(int i = 0; i < N; i++) {
			for(int j = 0 ; j < N; j++) {
				if(map[i][j] == '1' && !visited[i][j]) {
					cnt = 0;
					dfs(i, j);
					pq.add(cnt);
				}
			}
		}

		bw.write(pq.size() + "\n");
		while(!pq.isEmpty()) {
			bw.write(String.valueOf(pq.poll()) + "\n");
		}
		bw.flush();
		bw.close();
	}

	private static void dfs(int x, int y) {
		visited[x][y] = true;
		cnt++;

		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if(nx < 0 || ny < 0 || nx >= N || ny >= N || map[nx][ny] == '0' || visited[nx][ny]) {
				continue;
			}

			dfs(nx, ny);
		}
	}

}