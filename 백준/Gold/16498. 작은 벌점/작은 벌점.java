import java.io.*;
import java.util.*;

public class Main {

	static int A, B, C, ans;
	static int[] arr1, arr2 ,arr3;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer str;

		str = new StringTokenizer(br.readLine());
		A = Integer.parseInt(str.nextToken());
		B = Integer.parseInt(str.nextToken());
		C = Integer.parseInt(str.nextToken());

		arr1 = new int[A];
		arr2 = new int[B];
		arr3 = new int[C];

		str = new StringTokenizer(br.readLine());
		for(int i = 0; i < A; i++) {
			arr1[i] = Integer.parseInt(str.nextToken());
		}
		str = new StringTokenizer(br.readLine());
		for(int i = 0; i < B; i++) {
			arr2[i] = Integer.parseInt(str.nextToken());
		}
		str = new StringTokenizer(br.readLine());
		for(int i = 0; i < C; i++) {
			arr3[i] = Integer.parseInt(str.nextToken());
		}

		int a = 0, b = 0, c = 0;
		ans = Integer.MAX_VALUE;
		for(int i = 0; i < A; i++) {
			a = arr1[i];
			for(int j = 0; j < B; j++) {
				b = arr2[j];
				for(int p = 0; p < C; p++) {
					c = arr3[p];

					ans = Math.min(ans, Math.abs(Math.max(a, Math.max(b, c)) - Math.min(a, Math.min(b, c))));
				}
			}
		}

		sb.append(ans);

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}