import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static int[] arr, tArr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer str;

		str = new StringTokenizer(br.readLine());
		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());

		arr = new int[N+1];
		for(int i = 1; i <= N; i++) {
			arr[i] = i;
		}

		int i = 0, j = 0;
		while(M-- > 0) {
			str = new StringTokenizer(br.readLine());
			i = Integer.parseInt(str.nextToken());
			j = Integer.parseInt(str.nextToken());

			int tmp = j;
			tArr = new int[j-i+1];
			for(int k = 0; k < tArr.length; k++) {
				tArr[k] = arr[tmp--];
			}

			for(int k = 0; k < tArr.length; k++) {
				arr[i++] = tArr[k];
			}
		}

		for(int k = 1; k <= N; k++) {
			sb.append(arr[k]).append(" ");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}


}