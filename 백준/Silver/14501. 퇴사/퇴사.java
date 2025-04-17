import java.io.*;
import java.util.*;

public class Main {

	static int N, result;
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer str;

		N = Integer.parseInt(br.readLine());

		arr = new int[N][2];
		for(int i = 0; i < N; i++) {
			str = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(str.nextToken());
			arr[i][1] = Integer.parseInt(str.nextToken());
		}


		sb.append(sol(0));

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static int sol(int day) {
		if(day > N) {
			return Integer.MIN_VALUE;
		}

		if(day == N) {
			return 0;
		}


		return Math.max(sol(day+arr[day][0]) + arr[day][1], sol(day+1));
	}

}