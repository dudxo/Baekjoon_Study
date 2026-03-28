import java.io.*;
import java.util.*;


public class Main {

	static int N, M;
	static int[] arr;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		sb = new StringBuilder();

		StringTokenizer str = new StringTokenizer(br.readLine());
		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());

		arr = new int[M];

		sol(1, 1);

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static void sol(int depth, int start) {
		if(depth > M) {
			for(int i : arr) {
				sb.append(i).append(' ');
			}
			sb.append("\n");
			return;
		}

		for(int i = start; i <= N; i++) {
			arr[depth-1] = i;
			sol(depth + 1, i + 1);
		}
	}

}