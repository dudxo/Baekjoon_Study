import java.io.*;
import java.util.*;

public class Main {

	static int N, M, x1, x2, y1 ,y2;
	static int[][] arr, pSum;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer str;

		str = new StringTokenizer(br.readLine());
		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());

		arr = new int[N+1][N+1];
		pSum = new int[N+1][N+1];
		for(int i = 1; i <= N; i++) {
			str = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				arr[i][j] = Integer.parseInt(str.nextToken());
			}
		}

		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				pSum[i][j] = arr[i][j] + pSum[i-1][j] + pSum[i][j-1] - pSum[i-1][j-1];
			}
		}

		while(M-- > 0) {
			str = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(str.nextToken());
			y1 = Integer.parseInt(str.nextToken());
			x2 = Integer.parseInt(str.nextToken());
			y2 = Integer.parseInt(str.nextToken());

			int result = pSum[x2][y2] - pSum[x1-1][y2] - pSum[x2][y1-1] + pSum[x1-1][y1-1];
			sb.append(result).append("\n");

		}

		/*
		4 1
1 2 3 4
2 3 4 5
3 4 5 6
4 5 6 7
2 2 3 4
		 */

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}