import java.io.*;
import java.util.*;


public class Main {


	static int N, K;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer str = new StringTokenizer(br.readLine());

		N = Integer.parseInt(str.nextToken());
		K = Integer.parseInt(str.nextToken());

		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		int result = 0;
		for(int i = N-1; i >= 0; i--) {
			if(arr[i] <= K) {
				result += K / arr[i];
				K = K % arr[i];
			}
		}

		bw.write(String.valueOf(result));

		bw.flush();
		bw.close();
	}

}