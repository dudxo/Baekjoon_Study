import java.io.*;
import java.util.*;


public class Main {

	static final int MOD = 1_000_000_007;
	static int N;
	static long[][][][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer str;

		str = new StringTokenizer(br.readLine());
		N = Integer.parseInt(str.nextToken());

		dp = new long[N+1][4][2][3];
		for(int i = 0; i <= N; i++) {
			for(int j = 0; j < 4; j++) {
				for(int k = 0; k < 2; k++) {
					for(int p = 0; p < 3; p++) {
						dp[i][j][k][p] = -1;
					}
				}
			}
		}

		sb.append(recur(1, 0, 0, 0) % MOD);

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static long recur(int cur, int high, int flag, int seq) {
		if(seq > 2) {
			return 0;
		}

		if(high >= 4) {
			return 0;
		}

		if(cur > N) {
			return 0;
		}

		if(cur == N) {
			if(flag == 1) return 1;
			return 0;
		}

		if(dp[cur][high][flag][seq] != -1) {
			return dp[cur][high][flag][seq];
		}

		long a = recur(cur+1, high+1, flag, seq+1); // 현재 1 높이 선인장
		long b = recur(cur+1, high+2, 1, seq+1); // 현재 2 높이 선인장
		long c = recur(cur+1, 0, flag, 0); // 다음에 심기

		return dp[cur][high][flag][seq] = (a + b + c) % MOD;
	}

}
