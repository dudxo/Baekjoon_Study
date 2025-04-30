import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static int[] sum;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer str;

		str = new StringTokenizer(br.readLine());
		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());
		sum = new int[N+1];

		str = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			sum[i] = Integer.parseInt(str.nextToken()) + sum[i - 1];
		}

		int i = 1, max = Integer.MIN_VALUE;
		do {
			if(i-M < 0) {
				continue;
			}

			max = Math.max(max, sum[i] - sum[i - M]);
		} while(++i <= N);

		sb.append(max);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}


}