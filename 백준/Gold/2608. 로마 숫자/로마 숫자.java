import java.io.*;
import java.util.*;

public class Main {

	static char[] N, M;
	static int[] index = new int[7];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer str;

		N = br.readLine().toCharArray();
		M = br.readLine().toCharArray();
		
		int sum = converterToNumber(N) + converterToNumber(M);
		sb.append(sum).append("\n");
		sb.append(converterToString(sum));

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static String converterToString(int num) {
		StringBuilder sb2 = new StringBuilder();

			if(num / 1000 != 0) {
				for(int i = 0; i < (num / 1000); i++) {
					sb2.append("M");
				}
				index[6] += num / 1000;
				num %= 1000;
			}

			if(num / 900 != 0) {
				for(int i = 0; i < (num / 900); i++) {
					sb2.append("CM");
				}
				num %= 900;
			}

			if(num / 500 != 0) {
				for(int i = 0; i < (num / 500); i++) {
					sb2.append("D");
				}
				num %= 500;
			}

			if(num / 400 != 0) {
				for(int i = 0; i < (num / 400); i++) {
					sb2.append("CD");
				}
				num %= 400;
			}

			if(num / 100 != 0) {
				for(int i = 0; i < (num / 100); i++) {
					sb2.append("C");
				}
				num %= 100;
			}

			if(num / 90 != 0) {
				for(int i = 0; i < (num / 90); i++) {
					sb2.append("XC");
				}
				num %= 90;
			}

			if(num / 50 != 0) {
				for(int i = 0; i < (num / 50); i++) {
					sb2.append("L");
				}
				num %= 50;
			}

			if(num / 40 != 0) {
				for(int i = 0; i < (num / 40); i++) {
					sb2.append("XL");
				}
				num %= 40;
			}

			if(num / 10 != 0) {
				for(int i = 0; i < (num / 10); i++) {
					sb2.append("X");
				}
				num %= 10;
			}

			if(num / 9 != 0) {
				for(int i = 0; i < (num / 9); i++) {
					sb2.append("IX");
				}
				num %= 9;
			}

			if(num / 5 != 0) {
				for(int i = 0; i < (num / 5); i++) {
					sb2.append("V");
				}
				num %= 5;
			}

			if(num / 4 != 0) {
				for(int i = 0; i < (num / 4); i++) {
					sb2.append("IV");
				}
				num %= 4;
			}

			if(num / 1 != 0) {
				for(int i = 0; i < (num / 1); i++) {
					sb2.append("I");
				}
				num = 0;
		}

		return sb2.toString();
	}

	static int converterToNumberFromChar(char c) {
		switch (c) {
			case 'I':
				return 1;
			case 'V':
				return 5;
			case 'X':
				return 10;
			case 'L':
				return 50;
			case 'C':
				return 100;
			case 'D':
				return 500;
			case 'M':
				return 1000;
		}

		return 0;
	}

	static int converterToNumber(char[] arr) {
		Deque<Character> q = new ArrayDeque<>();
		init(arr, q);

		int size = q.size();
		int num = 0;

		if(size == 1) {
			num += converterToNumberFromChar(q.poll());
			return num;
		}

		while(size > 0) {
			char c = q.poll();
			if(c != '-') {
				q.addLast(c);
				size--;
				continue;
			}

			num += converterToNumberFromChar(q.pollFirst()) - converterToNumberFromChar(q.pollLast());
			size -= 2;
		}

		boolean flag = true;
		while(!q.isEmpty()) {
			char c = q.poll();
			switch (c) {
				case 'I':
					if(flag) num += 1;
					else num -= 1;
					break;
				case 'V':
					if(flag) num += 5;
					else num -= 1;
					break;
				case 'X':
					if(flag) num += 10;
					else num -= 1;
					break;
				case 'L':
					if(flag) num += 50;
					else num -= 1;
					break;
				case 'C':
					if(flag) num += 100;
					else num -= 1;
					break;
				case 'D':
					if(flag) num += 500;
					else num -= 1;
					break;
				case 'M':
					if(flag) num += 1000;
					else num -= 1;
					break;
				case '+':
					flag = true;
					break;
				case '-':
					flag = false;
					break;
			}
		}

		return num;
	}

	private static void init(char[] arr, Queue<Character> q) {
		for(int i = 0; i < arr.length-1; i++) {

			if(isCheck(arr[i], arr[i+1])) {
				q.add(arr[i]);
				q.add('+');
			} else {
				q.add(arr[i]);
				q.add('-');
			}
		}
		q.add(arr[arr.length-1]);
	}

	static boolean isCheck(char c1, char c2) {
		switch (c1) {
			case 'I':
				if(c2 != 'I') return false;
				return true;
			case 'V':
				if(c2 != 'I' && c2 != 'V') return false;
				return true;
			case 'X':
				if(c2 != 'I' && c2 != 'V' && c2 != 'X') return false;
				return true;
			case 'L':
				if(c2 != 'I' && c2 != 'V' && c2 != 'X' && c2 != 'L') return false;
				return true;
			case 'C':
				if(c2 != 'I' && c2 != 'V' && c2 != 'X' && c2 != 'L' && c2 != 'C') return false;
				return true;
			case 'D':
				if(c2 != 'I' && c2 != 'V' && c2 != 'X' && c2 != 'L' && c2 != 'C' && c2 != 'D') return false;
				return true;
			case 'M':
				if(c2 != 'I' && c2 != 'V' && c2 != 'X' && c2 != 'L' && c2 != 'C' && c2 != 'D' && c2 != 'M') return false;
				return true;
		}

		return false;
	}

}