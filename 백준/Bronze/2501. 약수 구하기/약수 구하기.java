import java.io.*;
import java.util.*;

public class Main {

	static int N, K;
	static boolean[] divisor;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer str;

		str = new StringTokenizer(br.readLine());
		N = Integer.parseInt(str.nextToken());
		K = Integer.parseInt(str.nextToken());

		divisor = new boolean[N+1];
		int count = 0;
		for(int i = 1; i <= N; i++) {
			if(N % i == 0) {
				divisor[i] = true;
				count++;
			}
		}

		int index = 0;
		int[] arr = new int[count+1];
		for(int i = 1; i <= count; i++) {
			while(index++ <= N) {
				if(divisor[index]) {
					arr[i] = index;
					break;
				}
			}
		}

		sb.append(count < K ? 0 : arr[K]);

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}


}