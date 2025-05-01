import java.io.*;
import java.util.*;

public class Main {

	static long N, M, K;
	static long[] arr, sum;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer str;

		str = new StringTokenizer(br.readLine());
		N = Long.parseLong(str.nextToken());
		K = Long.parseLong(str.nextToken());
		sum = new long[(int)N+1];

		long result = 0L;
		Map<Long, Long> map = new HashMap<>();
		map.put(0L, 1L);
		str = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			sum[i] = Long.parseLong(str.nextToken()) + sum[i - 1];

			result += map.getOrDefault(sum[i] - K, 0L);
			map.put(sum[i], map.getOrDefault(sum[i], 0L) + 1L);
		}

		sb.append(result);

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}


}