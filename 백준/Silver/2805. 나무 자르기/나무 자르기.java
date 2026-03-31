import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static int[] arr;
	static long max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer str = new StringTokenizer(br.readLine());

		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());
		max = Long.MIN_VALUE;

		arr = new int[N];
		str = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(str.nextToken());
		}
		Arrays.sort(arr);


		long s = 0, e = arr[N-1];

		while(s <= e) {
			long mid = (s + e) / 2;
			// 1 2 10 20
			// 잘랐을 때 M보다 작으면 << H를 낮추고
			// 잘랐을 때 M보다 크면 >> H 더 높여도 될가>?
			if(sol(mid)) {
				max = Math.max(mid, max);
				s = mid + 1;
			} else {
				e = mid - 1;
			}
		}

		bw.write(String.valueOf(max));

		bw.flush();
		bw.close();
	}

	private static boolean sol(long mid) {
		long sum = 0;
		for(int i = 0; i < N; i++) {
			if(arr[i] > mid) {
				sum += arr[i] - mid;
			}
		}

		return sum >= M;
	}

}