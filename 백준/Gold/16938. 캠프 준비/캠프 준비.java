import java.io.*;
import java.util.*;

public class Main {

	static int N, L, R, X, result;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer str;

		str = new StringTokenizer(br.readLine());
		N = Integer.parseInt(str.nextToken());
		L = Integer.parseInt(str.nextToken());
		R = Integer.parseInt(str.nextToken());
		X = Integer.parseInt(str.nextToken());

		arr = new int[N];
		str = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(str.nextToken());
		}

		recur(0, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
		sb.append(result);

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static void recur(int cur, int total, int min, int max) {
		if(cur > N) {
			return;
		}

		if(cur == N) {
			if(L <= total && total <= R && Math.abs(max - min) >= X) {
				result++;
			}
			return;
		}


		// 현재 문제 고르기
		recur(cur+1, total+arr[cur], Math.min(min, arr[cur]), Math.max(max, arr[cur]));

		// 현재 문제 고르지 않기
		recur(cur+1, total, min, max);
	}

}