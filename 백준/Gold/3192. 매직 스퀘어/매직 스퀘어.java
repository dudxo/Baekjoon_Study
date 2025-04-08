import java.io.*;
import java.util.*;

public class Main {

	static int[][] map;
	static Queue<int[]> zeros;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer str;

		map = new int[3][3];
		zeros = new ArrayDeque<>();

		int num = 0;
		for(int i = 0; i < 3; i++) {
			str = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++) {
				num = Integer.parseInt(str.nextToken());
				if(num == 0) zeros.add(new int[] {i, j});

				map[i][j] = num;
			}
		}

		int total = 0;
		if(map[1][1] == 0) {
			if(map[0][0] != 0 && map[2][2] != 0) {
				total += map[0][0] + map[2][2];
			} else if(map[0][2] != 0 && map[2][0] != 0) {
				total += map[0][2] + map[2][0];
			} else if(map[0][1] != 0 && map[2][1] != 0) {
				total += map[0][1] + map[2][1];
			} else if(map[1][0] != 0 && map[1][2] != 0) {
				total += map[1][0] + map[1][2];
			}

		} else {
			total = map[1][1] * 2;
		}

		int count = 0;
		while(count++ < 3) {
			if(zeros.isEmpty()) continue;

			int[] now = zeros.poll();
			int x = now[0];
			int y = now[1];

			if(x == 1 && y == 1) {
				map[x][y] = total / 2;
				continue;
			}

			if(x == 0 && y == 0) {
				if(map[2][2] == 0) {
					zeros.add(now);
					continue;
				}

				map[x][y] = Math.abs(total-map[2][2]);
			} else if(x == 2 && y == 2) {
				if(map[0][0] == 0) {
					zeros.add(now);
					continue;
				}

				map[x][y] = Math.abs(total-map[0][0]);
			} else if(x == 0 && y == 2) {
				if(map[2][0] == 0) {
					zeros.add(now);
					continue;
				}

				map[x][y] = Math.abs(total-map[2][0]);
			} else if(x == 2 && y == 0) {
				if(map[0][2] == 0) {
					zeros.add(now);
					continue;
				}

				map[x][y] = Math.abs(total-map[0][2]);
			} else if(x == 1 && y == 0) {
				if(map[1][2] == 0) {
					zeros.add(now);
					continue;
				}

				map[x][y] = Math.abs(total-map[1][2]);
			} else if(x == 1 && y == 2) {
				if(map[1][0] == 0) {
					zeros.add(now);
					continue;
				}

				map[x][y] = Math.abs(total-map[1][0]);
			} else if(x == 0 && y == 1) {
				if(map[2][1] == 0) {
					zeros.add(now);
					continue;
				}

				map[x][y] = Math.abs(total-map[2][1]);
			} else if(x == 2 && y == 1) {
				if(map[0][1] == 0) {
					zeros.add(now);
					continue;
				}

				map[x][y] = Math.abs(total-map[0][1]);
			}
		}

		while(!zeros.isEmpty()) {
			int[] now = zeros.poll();
			int x = now[0];
			int y = now[1];

			boolean flag = true;
			for(int i = 0; i < 3; i++) {
				if(i == y) continue;
				if(map[x][i] == 0) flag = false;
			}

			int sum = 0;
			if(flag) {
				sum = map[x][0] + map[x][1] + map[x][2];
				map[x][y] = Math.abs((total + (total/2)) - sum);
				continue;
			}

			flag = true;
			for(int i = 0; i < 3; i++) {
				if(i == x) continue;
				if(map[i][y] == 0) flag = false;
			}

			if(flag) {
				sum = map[0][y] + map[1][y] + map[2][y];
				map[x][y] = Math.abs((total + (total/2)) - sum);
				continue;
			}

			zeros.add(new int[] {x, y});
		}

		for(int[] arr : map) {
			for(int i : arr) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
	}



}