import java.io.*;
import java.util.*;


public class Main {

	static char[][] map;
	static int[][] dist;
	static int N, M, cnt;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer str = new StringTokenizer(br.readLine());
		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());

		map = new char[N][M];
		dist = new int[N][M];

		String s = "";
		for(int i = 0; i < N; i++) {
			s = br.readLine();
			map[i] = s.toCharArray();
		}

		bfs();

		bw.write(String.valueOf(dist[N-1][M-1]));
		bw.flush();
		bw.close();
	}

	private static void bfs() {
		ArrayDeque<int[]> dq = new ArrayDeque<>();
		dq.add(new int[] {0, 0});
		dist[0][0] = 1;

		while(!dq.isEmpty()) {
			int[] now = dq.poll();

			if(now[0] == N-1 && now[1] == M-1) return;

			for(int k = 0; k < 4; k++) {
				int nx = now[0] + dx[k];
				int ny = now[1] + dy[k];

				if(nx >= 0 && ny >= 0 && nx < N && ny < M && map[nx][ny] != '0' && dist[nx][ny] == 0) {
					dq.add(new int[] {nx, ny});
					dist[nx][ny] = dist[now[0]][now[1]] + 1;
				}
			}
		}

	}
}