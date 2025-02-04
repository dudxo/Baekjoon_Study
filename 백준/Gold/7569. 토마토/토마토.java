import java.io.*;
import java.util.*;

public class Main {

	static int N, M, H, day, size;
	static int[] dx = {0, 0, 0, 1, 0, -1};
	static int[] dy = {0, 0, 1, 0, -1, 0};
	static int[] dz = {1, -1, 0, 0, 0, 0};
	static int[][][] boxs;
	static int GREEN_TOMATO, RED_TOMATO;
	static boolean[][][] visited;
	static Queue<int[]> q = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		RED_TOMATO = 0;
		GREEN_TOMATO = 0;

		StringTokenizer str = new StringTokenizer(br.readLine());
		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());
		H = Integer.parseInt(str.nextToken());

		boxs = new int[H][M][N];
		visited = new boolean[H][M][N];

		for(int i = 0; i < H; i++) {
			for(int j = 0; j < M; j++) {
				str = new StringTokenizer(br.readLine());
				for(int k = 0; k < N; k++) {
					int status = Integer.parseInt(str.nextToken());
					if(status == 1) {
						RED_TOMATO += 1;
						q.add(new int[] {i, j, k});
						visited[i][j][k] = true;
					} else if(status == 0) {
						GREEN_TOMATO += 1;
					}

					boxs[i][j][k] = status;
				}
			}
		}

		if(GREEN_TOMATO == 0) {
			sb.append("0");
		} else {
			BFS();
			if(GREEN_TOMATO > 0) {
				sb.append("-1");
			} else {
				sb.append(day-1);
			}
		}

		br.close();
		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

	private static void BFS() {
		day = 0;
		size = 0;
		do {
			size = q.size();

			while(size-- > 0) {
				int[] now = q.poll();

				for(int a = 0; a < 6; a++) {
					int nz = now[0] + dz[a];
					int nx = now[1] + dx[a];
					int ny = now[2] + dy[a];

					if(nz < 0 || nx < 0 || ny < 0 || nz >= H || nx >= M || ny >= N || visited[nz][nx][ny]) {
						continue;
					}

					if(boxs[nz][nx][ny] == 0) {
						boxs[nz][nx][ny] = 1;
						visited[nz][nx][ny] = true;
						q.add(new int[] {nz, nx, ny});
						GREEN_TOMATO -= 1;
					}
				}
			}

			day += 1;
		} while(q.size() > 0);
	}
}