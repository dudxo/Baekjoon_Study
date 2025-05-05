import java.io.*;
import java.util.*;

public class Main {

	static int N, H;
	static int[] arr, pSum;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer str;

		str = new StringTokenizer(br.readLine());
		N = Integer.parseInt(str.nextToken());
		H = Integer.parseInt(str.nextToken());

		arr = new int[H+2];
		pSum = new int[H+1];

		int h = 0, st = 0, ed = 0;
		boolean flag = true;
		for(int i = 1; i <= N; i++) {
			h = Integer.parseInt(br.readLine());

			if(flag) {
				st = 1;
				ed = h;
			} else {
				st = H-h+1;
				ed = H;
			}


			arr[st] += 1;
			arr[ed+1] -= 1;

			flag = !flag;
		}

		int min = Integer.MAX_VALUE, count = 0;
		for(int i = 1; i <= H; i++) {
			pSum[i] = pSum[i-1] + arr[i];

			if(pSum[i] < min) {
				min = pSum[i];
				count = 1;
			} else if(pSum[i] == min) {
				count++;
			}
		}

		sb.append(min).append(" ").append(count);

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}