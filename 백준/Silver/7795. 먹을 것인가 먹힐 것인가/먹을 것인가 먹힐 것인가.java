import java.io.*;
import java.util.*;

public class Main {

	static int T, A, B, result;
	static int[] arr1, arr2;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());

		while(T-- > 0) {
			result = 0;
			StringTokenizer str = new StringTokenizer(br.readLine());
			A = Integer.parseInt(str.nextToken());
			B = Integer.parseInt(str.nextToken());

			arr1 = new int[A];
			arr2 = new int[B];

			str = new StringTokenizer(br.readLine());
			for(int i = 0; i < A; i++) {
				arr1[i] = Integer.parseInt(str.nextToken());
			}

			str= new StringTokenizer(br.readLine());
			for(int i = 0; i < B; i++) {
				arr2[i] = Integer.parseInt(str.nextToken());
			}

			Arrays.sort(arr2);

			for(int i = 0; i < A; i++) {
				result += sol(arr1[i]);
			}
			sb.append(result).append("\n");
		}


		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}

	private static int sol(int i) {
		int st = 0;
		int ed = B-1;

		while(st <= ed) {
			if(arr2[ed] < i) {
				return ed+1;
			}

			if(arr2[st] < i) {
				st++;
			}
			if(arr2[ed] >= i) {
				ed--;
			}
		}

		if(ed < 0) {
			return 0;
		}
		return ed+1;
	}

}