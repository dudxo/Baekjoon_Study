import java.io.*;
import java.util.*;

public class Main {

	static int N, count, ans;
	static boolean[] isPrime;
	static int[] arr;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer str;

		N = Integer.parseInt(br.readLine());
		isPrime = new boolean[N+1];
		for(int i = 1; i <= N; i++) {
			isPrime[i] = true;
		}
		isPrime[1] = false;

		// 1~ N 사이 소수 검증
		count = 1;
		for(int i = 2; i <= N; i++) {
			if(!isPrime[i]) continue;

			int j = 2;
			while(true) {
				int mul = i*j;
				if(mul > N) {
					break;
				}

				if(isPrime[mul]) {
					isPrime[mul] = false;
					count++;
				}
				j++;
			}
		}

		int index = 1;
		arr = new int[N-count];
		for(int i = 0; i < arr.length; i++) {
			while(index++ < N) {
				if(isPrime[index]) {
					arr[i] = index;
					break;
				}
			}
		}

		if(N != 1) {
			// 연속된 소수의 합
			int s = 0, e = 0, sum = arr[e];

			while (s <= e && e < arr.length - 1) {
				if (sum == N) {
					ans++;
					sum -= arr[s];
					s++;
					e++;
					sum += arr[e];
				} else if (sum < N) {
					e++;
					sum += arr[e];
				} else if (sum > N) {
					sum -= arr[s];
					s++;
				}
			}

			if (arr[arr.length - 1] == N)
				ans++;

		}
		sb.append(ans);

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}