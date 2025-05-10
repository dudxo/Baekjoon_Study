import java.io.*;
import java.util.*;

public class Main {

	static int S, K, ans;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer str;

		str = new StringTokenizer(br.readLine());
		S = Integer.parseInt(str.nextToken());
		K = Integer.parseInt(str.nextToken());

		arr = new int[S];
		str = new StringTokenizer(br.readLine());
		for(int i = 0; i < S; i++) {
			arr[i] = Integer.parseInt(str.nextToken());
		}

		int s = 0, e = 0, odd = 0;
		while(e < S) {
			if(isOdd(arr[e])) {
				odd++;
			}

			if(odd > K) {
				ans = Math.max(ans, e-s-K);

				// 1. arr[s] == odd
				// 2. arr[s] != odd

				while(!isOdd(arr[s]) && s < e) {
					s++;
				}
				odd--;
				s++;
				e++;
			} else if(odd <= K) {
				e++;
			}
		}

		if(odd > K) {
			while(!isOdd(arr[s]) && s < e) {
				s++;
			}
		}
		ans = Math.max(ans, e-s-odd);

		sb.append(ans);



		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static boolean isOdd(int num) {
		return (num % 2) == 1;
	}
}