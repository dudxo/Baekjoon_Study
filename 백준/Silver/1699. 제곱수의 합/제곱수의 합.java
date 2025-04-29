import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer str;

		N = Integer.parseInt(br.readLine());
		int max = (int) Math.sqrt(N);
		dp = new int[max+2][N+1];

		for(int i = 0; i <= max+1; i++) {
			for(int j = 0; j <= N; j++) {
				dp[i][j] = -1;
			}
		}

		sb.append(recur(1, 0));

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static int recur(int cur, int total) {
		if(total == N) {
			return 0;
		}

		if(cur * cur > N || total > N) {
			return 2131241411;
		}

		if(dp[cur][total] != -1) {
			return dp[cur][total];
		}

		int num1 = recur(cur, total + (cur * cur));
		if(num1 != 2131241411) {
			num1 += 1;
		}

		int num2 = recur(cur+1, total);

		return dp[cur][total] = Math.min(num1, num2);
	}

}