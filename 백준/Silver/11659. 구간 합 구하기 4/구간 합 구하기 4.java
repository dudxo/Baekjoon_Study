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

		int i = 0, j = 0;
		while(M-- > 0) {
			str = new StringTokenizer(br.readLine());
			i = Integer.parseInt(str.nextToken());
			j = Integer.parseInt(str.nextToken());

			sb.append(sum[j] - sum[i-1]).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}


}