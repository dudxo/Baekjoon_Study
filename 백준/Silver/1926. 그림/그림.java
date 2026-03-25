import java.io.*;
import java.util.*;


public class Main {

	static int[][] map;
	static boolean[][] visited;
	static int N, M, cnt, size;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer str = new StringTokenizer(br.readLine());
		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());

		map = new int[N][M];
		visited = new boolean[N][M];

		cnt = 0;
		size = Integer.MIN_VALUE;

		for(int i = 0; i < N; i++) {
			str = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(str.nextToken());
			}
		}

		for(int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 1 && !visited[i][j]) {
					cnt++;
					bfs(i, j);
				}
			}
		}

		bw.write(String.valueOf(cnt) + "\n" + String.valueOf(size == Integer.MIN_VALUE ? 0 : size));
		bw.flush();
		bw.close();
	}

	private static void bfs(int x, int y) {
		ArrayDeque<int[]> dq = new ArrayDeque<>();
		dq.add(new int[] {x, y});
		visited[x][y] = true;
		int tmp = 1;

		while(!dq.isEmpty()) {
			int[] now = dq.poll();

			for(int k = 0; k < 4; k++) {
				int nx = now[0] + dx[k];
				int ny = now[1] + dy[k];

				if(nx >= 0 && ny >= 0 && nx < N && ny < M && map[nx][ny] != 0 && !visited[nx][ny]) {
					dq.add(new int[] {nx, ny});
					visited[nx][ny] = true;
					tmp++;
				}
			}
		}

		size = Math.max(size, tmp);
	}
}