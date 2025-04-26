import java.io.*;
import java.util.*;
public class Main {

	static int N, M, st, ed, k;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer str;

		str = new StringTokenizer(br.readLine());
		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());
		arr = new int[N+1];

		for(int i = 0; i < M; i++) {
			str = new StringTokenizer(br.readLine());
			st = Integer.parseInt(str.nextToken());
			ed = Integer.parseInt(str.nextToken());
			k = Integer.parseInt(str.nextToken());
			for(int j = st; j <= ed; j++) {
				arr[j] = k;
			}
		}

		for(int i = 1; i <= N; i++) {
			sb.append(arr[i]).append(" ");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}