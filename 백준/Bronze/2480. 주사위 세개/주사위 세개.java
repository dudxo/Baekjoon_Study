import java.io.*;
import java.util.*;

public class Main {

	static int A, B, C;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer str;

		str = new StringTokenizer(br.readLine());
		A = Integer.parseInt(str.nextToken());
		B = Integer.parseInt(str.nextToken());
		C = Integer.parseInt(str.nextToken());

		if(A == B && B == C) {
			sb.append(10_000+(A * 1000));
		} else if(A == B || B == C || A == C) {
			sb.append(1000+((A == B ? A : C) * 100));
		} else {
			sb.append(Math.max(A, Math.max(B, C)) * 100);
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}


}