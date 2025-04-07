import java.io.*;
import java.util.*;

public class Main {

	static int N, M, result;
	static int[] dx = new int[] {0, 1, 0, -1, -1, 1, -1, 1};
	static int[] dy = new int[] {1, 0, -1, 0, -1, -1, 1, 1};
	static int[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer str;

		str = new StringTokenizer(br.readLine());
		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());

		map = new int[N][M];
		visited = new boolean[N][M];
		for(int i = 0; i < N; i++) {
			str = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(str.nextToken());
			}
		}

		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(!visited[i][j]) {
					if(sol(i, j)) {
						result++;
					}
				}
			}
		}



		bw.write(String.valueOf(result));
		bw.flush();
	}

	private static boolean sol(int i, int j) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {i, j});
		boolean[][] visited2 = new boolean[N][M];
		visited[i][j] = true;
		visited2[i][j] = true;

		boolean flag = true;


		int height = map[i][j];

		while(!queue.isEmpty()) {
			int[] now = queue.poll();

			for(int k = 0; k < 8; k++) {
				int nx = now[0] + dx[k];
				int ny = now[1] + dy[k];

				if(nx < 0 || ny < 0 || nx >= N || ny >= M || visited2[nx][ny]) continue;

				if(map[nx][ny] > height) {
					flag = false;
					continue;
				}

				if(map[nx][ny] == height && !visited[nx][ny]) {
					visited[nx][ny] = true;
					visited2[nx][ny] = true;
					queue.add(new int[] {nx, ny});
				}

			}
		}


		return flag;
	}

}