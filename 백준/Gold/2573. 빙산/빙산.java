import java.io.*;
import java.util.*;

public class Main {

	static int N, M, year, area, size;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int[][] map, tmp;
	static boolean[][] visited;
	static Queue<int[]> q = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		StringTokenizer str = new StringTokenizer(br.readLine());
		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());

		map = new int[N][M];
		tmp = new int[N][M];
		visited = new boolean[N][M];

		for(int i = 0; i < N; i++) {
			str = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				int status = Integer.parseInt(str.nextToken());

				if(status != 0) {
					q.add(new int[] {i, j});
				}
				map[i][j] = status;
			}
		}

		BFS();
		if(area < 2) {
			sb.append("0");
		} else {
			sb.append(year);
		}

		br.close();
		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

	private static void BFS() {
		year = 0;
		size = 0;

		while(!q.isEmpty()) {
			size = q.size();

			areaCheck();

			if(area != 1) {
				break;
			}
			year += 1;

			while(size-- > 0) {
				int[] now = q.poll();

				for(int k = 0; k < 4; k++) {
					int nx = now[0] + dx[k];
					int ny = now[1] + dy[k];

					if(nx < 0 || ny < 0 || nx >= N || ny >= M) {
						continue;
					}

					if(map[nx][ny] == 0) {
						tmp[now[0]][now[1]] += 1;
					}

				}
			}

			for(int a = 0; a < N; a++) {
				for(int b = 0; b < M; b++) {
					if(tmp[a][b] != 0) {
						map[a][b] = map[a][b] - tmp[a][b] < 0 ? 0 : map[a][b] - tmp[a][b];
						tmp[a][b] = 0;
					}
					if(map[a][b] >= 1) {
						q.add(new int[] {a, b});
					}
				}
			}


		}
	}

	private static void areaCheck() {
		visited = new boolean[N][M];
		area = 0;

		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(!visited[i][j] && map[i][j] > 0) {
					BFS2(i, j);
					area += 1;
				}
			}
		}
	}

	private static void BFS2(int i, int j) {
		Queue<int[]> q2 = new LinkedList<>();
		q2.add(new int[] {i, j});
		visited[i][j] = true;

		while(!q2.isEmpty()) {
			int[] now = q2.poll();

			for(int k = 0; k < 4; k++) {
				int nx = now[0] + dx[k];
				int ny = now[1] + dy[k];

				if(nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny]) {
					continue;
				}

				if(map[nx][ny] > 0) {
					visited[nx][ny] = true;
					q2.add(new int[] {nx, ny});
				}
			}
		}
	}

}