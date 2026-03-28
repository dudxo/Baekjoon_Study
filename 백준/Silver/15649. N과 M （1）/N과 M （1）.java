import java.io.*;
import java.util.*;


public class Main {

	static int N, M;
	static int[] arr;
	static boolean[] isUsed;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		sb = new StringBuilder();

		StringTokenizer str = new StringTokenizer(br.readLine());
		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());

		arr = new int[M];
		isUsed = new boolean[N+1];

		sol(1);

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static void sol(int depth) {
		if(depth > M) {
			for(int i : arr) {
				sb.append(i + " ");
			}
			sb.append("\n");
			return;
		}

		for(int i = 1; i <= N; i++) {
			if(!isUsed[i]) {
				arr[depth-1] = i;
				isUsed[i] = true;
				sol(depth+1);
				isUsed[i] = false;
			}
		}
	}

}