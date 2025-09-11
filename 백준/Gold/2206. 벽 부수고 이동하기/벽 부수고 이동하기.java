import java.io.*;
import java.util.*;

public class Main {

	static int x, y;
	static char[][] map;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer str;
		int ans = 0;

		str = new StringTokenizer(br.readLine());
		x = Integer.parseInt(str.nextToken());
		y = Integer.parseInt(str.nextToken());

		map = new char[x][y];

		String s;
		for(int i = 0; i < x; i++) {
			s = br.readLine();
			map[i] = s.toCharArray();
		}



		bw.write(String.valueOf(sol()));
		bw.flush();
		bw.close();
	}

	private static int sol() {
		if(x-1 == 0 && y-1 == 0) return 1;

		ArrayDeque<int[]> dq = new ArrayDeque<>();
		boolean[][][] visited = new boolean[2][x][y];
		int[][] dist = new int[x][y];

		dq.add(new int[]{0, 0, 0});
		visited[0][0][0] = true;
		dist[0][0] = 0;

		while(!dq.isEmpty()) {
			int[] now = dq.poll();

			for(int k = 0; k < 4; k++) {
				int nx = now[0] + dx[k];
				int ny = now[1] + dy[k];

				if(nx < 0 || ny < 0 || nx >= x || ny >= y) continue;

				if(map[nx][ny] == '1') {
					if(now[2] == 0 && !visited[1][nx][ny]) {
						visited[now[2]][nx][ny] = true;
						dist[nx][ny] = dist[now[0]][now[1]] + 1;
						dq.add(new int[] {nx, ny, 1});
					}
				}

				if(map[nx][ny] == '0') {
					if(!visited[now[2]][nx][ny]) {
						visited[now[2]][nx][ny] = true;
						dist[nx][ny] = dist[now[0]][now[1]] + 1;
						dq.add(new int[] {nx, ny, now[2]});
					}
				}

				if(nx == x-1 && ny == y-1) {
					return dist[nx][ny] + 1;
				}
			}
		}

		return -1;
	}
}

