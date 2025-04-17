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
		sol(0, 0);

		sb.append(result);

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static void sol(int day, int total) {
		if(day > N) {
			return;
		}

		if(day == N) {
			result = Math.max(result, total);
			return;
		}


		// 오늘 일 하기
		sol(day+arr[day][0], total + arr[day][1]);

		// 오늘 안하고 내일 하기
		sol(day+1, total);
	}

}