import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, T;
	static int[][] arr;
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer str;

		str = new StringTokenizer(br.readLine());

		N = Integer.parseInt(str.nextToken());
		T = Integer.parseInt(str.nextToken());

		arr = new int[N][2];
		for(int i = 0; i < N; i++) {
			str = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(str.nextToken());
			arr[i][1] = Integer.parseInt(str.nextToken());
		}

		dp = new int[N][T + 1];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= T; j++) {
				dp[i][j] = -1;
			}
		}


		sb.append(sol(0, 0));

		// sb.append(result);


		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static int sol(int index, int time) {
		if(time > T) {
			return Integer.MIN_VALUE;
		}

		if(index == N) {
			return 0;
		}

		if(dp[index][time] != -1) {
			return dp[index][time];
		}

		dp[index][time] = Math.max(sol(index + 1, time + arr[index][0]) + arr[index][1], sol(index+1, time));

		return dp[index][time];
	}

}
