import java.io.*;
import java.util.*;
public class Main {

	static int N, min, max;
	static int[] arr, arr2, num;
	static char[] tmpArr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer str;

		arr = new int[4];
		N = Integer.parseInt(br.readLine());
		num = new int[N];
		arr2 = new int[N-1];
		tmpArr = new char[N-1];
		str = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(str.nextToken());
		}

		str = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i++) {
			arr[i] = Integer.parseInt(str.nextToken());
		}

		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;

		sol(0, 0, 0, 0, 0, 0, 0);

		sb.append(max).append("\n").append(min);

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static void sol(int depth, int cur, int sum, int sub, int mul, int div, int total) {

		if(cur > 3) {
			return;
		}

		if(depth > N-1) {
			return;
		}

		if(depth == N-1) {
			// print();
			int tmp = calculate();
			max = Math.max(max, tmp);
			min = Math.min(min, tmp);
		}


		// 지금 선택하고 가만히 있기
		switch (cur) {
			case 0:
				if(arr[cur] > sum) {
					tmpArr[depth] = '+';
					sol(depth+1, 0, sum+1, sub, mul, div, total+1);
				}
				break;
			case 1:
				if(arr[cur] > sub) {
					tmpArr[depth] = '-';
					sol(depth+1, 0, sum, sub+1, mul, div, total+1);
				}
				break;
			case 2:
				if(arr[cur] > mul) {
					tmpArr[depth] = '*';
					sol(depth+1, 0, sum, sub, mul+1, div, total+1);
				}
				break;
			case 3:
				if(arr[cur] > div) {
					tmpArr[depth] = '/';
					sol(depth+1, 0, sum, sub, mul, div+1, total+1);
				}
				break;
		}

		// 지금 선택하고 다음으로 이동
		switch (cur) {
			case 0:
				if(arr[cur] > sum) {
					tmpArr[depth] = '+';
					sol(depth+1, cur+1, sum+1, sub, mul, div, total+1);
				}
				break;
			case 1:
				if(arr[cur] > sub) {
					tmpArr[depth] = '-';
					sol(depth+1, cur+1, sum, sub+1, mul, div, total+1);
				}
				break;
			case 2:
				if(arr[cur] > mul) {
					tmpArr[depth] = '*';
					sol(depth+1, cur+1, sum, sub, mul+1, div, total+1);
				}
				break;
			case 3:
				if(arr[cur] > div) {
					tmpArr[depth] = '/';
					sol(depth+1, cur+1, sum, sub, mul, div+1, total+1);
				}
				break;
		}

		// 지금 선택하지 않고 다음으로 이동
		sol(depth, cur+1, sum, sub, mul, div, total);

	}

	// private static void print() {
	// 	for(char c : tmpArr) {
	// 		System.out.print(c + ", ");
	// 	}
	// 	System.out.println();
	// }

	private static int calculate() {
		int tmp = num[0];
		for(int i = 0; i < N-1;) {
			char c = tmpArr[i++];
			switch (c) {
				case '+':
					tmp += num[i];
					break;
				case '-':
					tmp -= num[i];
					break;
				case '*':
					tmp *= num[i];
					break;
				case '/':
					tmp /= num[i];
					break;
			}
		}

		return tmp;
	}
}