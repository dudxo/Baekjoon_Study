import java.io.*;
import java.util.*;

public class Main {

	static int T, k, n, ans, sub;
	static int[] a, b, c, d, pSum1, pSum2;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer str;

		T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			ans = Integer.MAX_VALUE;
			sub = Integer.MAX_VALUE;
			str = new StringTokenizer(br.readLine());
			k = Integer.parseInt(str.nextToken());
			n = Integer.parseInt(str.nextToken());

			a = new int[n];
			b = new int[n];
			c = new int[n];
			d = new int[n];

			init(a, str, br);
			init(b, str, br);
			init(c, str, br);
			init(d, str, br);

			int Nsqrt = n*n;
			pSum1 = new int[Nsqrt];
			pSum2 = new int[Nsqrt];

			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					pSum1[(i*n)+j] = a[i] + b[j];
					pSum2[(i*n)+j] = c[i] + d[j];
				}
			}

			Arrays.sort(pSum1);
			Arrays.sort(pSum2);

			//[103, 108, 115, 115, 120, 123, 127, 128, 128, 135, 140, 143, 148, 148, 155, 168]
			//[97, 97, 103, 104, 104, 110, 121, 121, 123, 123, 127, 129, 142, 149, 166, 168]

			int s = 0, e = Nsqrt-1, sum = 0;

			// 135(9), 166(14)

			while(s < Nsqrt && e >= 0) {
				sum = pSum1[s] + pSum2[e];

				int tmp = Math.abs(k - sum);
				if(tmp == 0) {
					ans = sum;
					break;
				}

				else if(tmp < sub || (tmp == sub && sum < ans)) {
					sub = tmp;
					ans = sum;
				}

				if(sum < k) {
					s++;
				}

				else if(sum > k) {
					e--;
				}
			}



			sb.append(ans).append("\n");
		}



		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static void init(int[] arr, StringTokenizer str, BufferedReader br) throws IOException {
		str = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(str.nextToken());
		}
	}

}