import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int[] A, B, C, D;
	static long[] arr1, arr2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer str;

		N = Integer.parseInt(br.readLine());
		A = new int[N];
		B = new int[N];
		C = new int[N];
		D = new int[N];


		for(int i = 0; i < N; i++) {
			str = new StringTokenizer(br.readLine());
			for(int j = 0; j < 4; j++) {
				if(j == 0) A[i] = Integer.parseInt(str.nextToken());
				else if(j == 1) B[i] = Integer.parseInt(str.nextToken());
				else if(j == 2) C[i] = Integer.parseInt(str.nextToken());
				else D[i] = Integer.parseInt(str.nextToken());
			}
		}

		// Arrays.sort(A);
		// Arrays.sort(B);
		// Arrays.sort(C);
		// Arrays.sort(D);

		arr1 = new long[N*N];
		arr2 = new long[N*N];

		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
		 	 	arr1[(i*N) + j] = A[i] + B[j];
		 	 	arr2[(i*N) + j] = C[i] + D[j];
			}
		}

		Arrays.sort(arr1);
		Arrays.sort(arr2);

		long s = 0, e = (N*N)-1, ans = 0;
		while(s < N*N && e >= 0) {
			long sum = arr1[(int)s] + arr2[(int)e];
			if(sum == 0L){
				long cnt1 = 0, cnt2 = 0, tmp = arr1[(int)s];
				while(s < N*N && tmp == arr1[(int)s]) {
					cnt1++;
					s++;
				}

				tmp = arr2[(int)e];
				while(e >= 0 && tmp == arr2[(int)e]) {
					cnt2++;
					e--;
				}
				ans += (cnt1 * cnt2);
			}

			else if(sum > 0L) {
				e--;
			}

			else if(sum < 0L) {
				s++;
			}
		}

		/**

		 -45 -41 -36 -36 -32 26
		 -54 -38 -27 22 30 53
		 -75 -37 -10 -6 42 56
		 -46 -16 30 45 62 77

		 ==================
		 -45 -27 42 30
		 26 30 -10 -46
		 -32 22 56 -46
		 -32 30 -75 -77
		 -32 -54 56 30

		 */

		sb.append(ans);


		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}