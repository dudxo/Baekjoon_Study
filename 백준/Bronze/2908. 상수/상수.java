import java.io.*;
import java.util.*;

public class Main {

	static String A, B;
	static int a, b, ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer str;

		str = new StringTokenizer(br.readLine());
		A = str.nextToken();
		B = str.nextToken();

		for(int i = A.length()-1; i >= 0; i--) {
			sb.append(A.charAt(i));
		}

		a = Integer.parseInt(sb.toString());
		sb = new StringBuilder();

		for(int i = B.length()-1; i >= 0; i--) {
			sb.append(B.charAt(i));
		}

		b = Integer.parseInt(sb.toString());
		sb = new StringBuilder();
		sb.append(Math.max(a, b));


		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}