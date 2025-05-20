import java.io.*;
import java.util.*;

public class Main {

	static int ans, x, y;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer str;

		int n = Integer.parseInt(br.readLine());
 // 1 3 5 7 9 7 5 3 1

		int max = ((n-1) * 2) + 1;
		for(int i = 0; i < n; i++) {
			int j = (i*2) + 1;
			int mid = (max - j) / 2;
			for(int k = 0; k < mid; k++) {
				sb.append(" ");
			}
			for(int k = 0; k < j; k++) {
				sb.append("*");
			}
			sb.append("\n");
		}

		for(int i = n-1; i >= 1; i--) {
			int j = (i*2) - 1;
			int mid = (max - j) / 2;
			for(int k = 0; k < mid; k++) {
				sb.append(" ");
			}
			for(int k = 0; k < j; k++) {
				sb.append("*");
			}
			if(i > 1) {
				sb.append("\n");
			}
		}


		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}


}