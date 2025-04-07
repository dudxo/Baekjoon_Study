import java.io.*;
import java.util.*;

public class Main {

	static int N, M, result, sheep, wolf;
	static int[] dx = new int[] {0, 1, 0, -1};
	static int[] dy = new int[] {1, 0, -1, 0};
	static boolean[][] visited;
	static char[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer str;

		str = new StringTokenizer(br.readLine());
		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());

		map= new char[N][M];
		visited = new boolean[N][M];

		for(int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 'v') wolf++;
				else if(map[i][j] == 'o') sheep++;
			}
		}

		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 'v' || map[i][j] == 'o') {
					sol(i, j);
				}
			}
		}


		bw.write(sheep + " " + wolf);
		bw.flush();
	}

	private static void sol(int i, int j) {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {i, j});
		visited[i][j] = true;

		int o = 0, v = 0;
		if(map[i][j] == 'o') o++;
		else if(map[i][j] == 'v') v++;


		while(!q.isEmpty()) {
			int[] now = q.poll();

			for(int k = 0; k < 4; k++) {
				int nx = now[0] + dx[k];
				int ny = now[1] + dy[k];

				if(nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny] || map[nx][ny] == '#') continue;

				if(map[nx][ny] == 'o') o++;
				else if(map[nx][ny] == 'v') v++;

				visited[nx][ny] = true;
				q.add(new int[] {nx, ny});
			}
		}

		if(o > v) {
			wolf -= v;
		} else {
			sheep -= o;
		}
	}

}