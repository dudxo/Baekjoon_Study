import java.io.*;
import java.util.*;

public class Main {

	static int N, K, B, ans;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer str;

		str = new StringTokenizer(br.readLine());
		N = Integer.parseInt(str.nextToken());
		K = Integer.parseInt(str.nextToken());
		B = Integer.parseInt(str.nextToken());

		ans = Integer.MAX_VALUE;

		arr = new int[N+1];
		for(int i = 0; i < B; i++) {
			int index = Integer.parseInt(br.readLine());
			arr[index] = -1;
		}

		int s = 1, e = 1, count = arr[s] == -1 ? 1 : 0;
		while(s <= e && e < N) {
			e++;
			if(arr[e] == -1) count++;
			int len = e-s+1;
			if(len == K) {
				ans = Math.min(ans, count);
				if(arr[s] == -1) count--;
				s++;
			}

			else if(len > K) {
				if(arr[s] == -1) count--;
				s++;
			} 
		}

		sb.append(ans);

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}