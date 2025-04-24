import java.io.*;
import java.util.*;
public class Main {

	static int N, M;
	static int[][][][][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer str;

		str = new StringTokenizer(br.readLine());
		M = Integer.parseInt(str.nextToken());
		N = Integer.parseInt(str.nextToken());

		dp = new int[N+1][M+1][2][3][3];

		for(int i = 0; i <= N; i++) {
			for(int j = 0; j <= M; j++) {
				for(int k = 0; k < 2; k++) {
					for(int p = 0; p < 3; p++) {
						for (int q = 0; q < 3; q++) {
							dp[i][j][k][p][q] = -1;
						}
					}
				}
			}
		}

		sb.append(sol(1, 1, 0, 0, 0));

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	private static int sol(int x, int y, int cur, int xCount, int yCount) {
		if(cur == 0 ) {
			if(yCount == 1 && !(x == 2 && y == 2)) {  // 방금 전 우로 1칸 이동했고, 좌표가 [2,2]가 아닌 경우에 return
				return 0;
			}

			yCount = 0;
		} else if(cur == 1) {
			if(xCount == 1 && !(x == 2 && y == 2)) {   // 방금 전 위로 1칸 이동했고, 좌표가 [2,2]가 아닌 경우에 return
				return 0;
			}

			xCount = 0;
		}

		if(x > N || y > M) {
			return 0;
		}

		if(x == N && y == M) {
			return 1;
		}

		if(xCount >= 2) xCount = 2;
		if(yCount >= 2) yCount = 2;

		if(dp[x][y][cur][xCount][yCount] != -1) {
			return dp[x][y][cur][xCount][yCount];
		}

		return dp[x][y][cur][xCount][yCount] = (sol(x + 1, y, 0, xCount+1, yCount) + sol(x, y + 1, 1, xCount, yCount+1)) % 100000;
	}
}