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

		Arrays.sort(arr1);
		Arrays.sort(arr2);
		Arrays.sort(arr3);

		int index = 0;
		ans = Integer.MAX_VALUE;
		for(int i = 0; i < A; i++) {
			index = arr1[i];
			ans = Math.min(
				ans,
				Math.abs(Math.max(sol(arr2, index), sol(arr3, index)) - index));
		}

		for(int i = 0; i < B; i++) {
			index = arr2[i];
			ans = Math.min(
				ans,
				Math.abs(Math.max(sol(arr1, index), sol(arr3, index)) - index));
		}

		for(int i = 0; i < C; i++) {
			index = arr3[i];
			ans = Math.min(
				ans,
				Math.abs(Math.max(sol(arr2, index), sol(arr1, index)) - index));
		}

		sb.append(ans);

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static int sol(int[] arr, int num) {
		int s = 0, e = arr.length;
		while(s < e) {
			int mid = (s+e) / 2;
			if(arr[mid] < num) {
				s = mid+1;
			} else {
				e = mid;
			}
		}

		return e < arr.length ? arr[e] : Integer.MAX_VALUE;
	}
}