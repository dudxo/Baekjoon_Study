import java.io.*;
import java.util.*;

public class Main {

	static final int INF = Integer.MAX_VALUE;
	static int N, S, result;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer str;

		str = new StringTokenizer(br.readLine());
		N = Integer.parseInt(str.nextToken());
		S = Integer.parseInt(str.nextToken());

		arr = new int[N];
		str = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(str.nextToken());
		}

		recur(0, 0);

		if(S == 0) {
			result -= 1;
		}

		sb.append(result);

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static void recur(int cur, int sum) {
		if(cur > N) {
			return;
		}

		if(cur == N) {
			if(S == sum) {
				result++;
			}
			return;
		}

		// 현재 숫자 쓰기
		recur(cur+1, sum + arr[cur]);

		// 현재 숫자 안쓰기
		recur(cur+1, sum);
	}
}