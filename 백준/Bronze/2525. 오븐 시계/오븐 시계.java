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

		C = Integer.parseInt(br.readLine());

		B += C;

		A += (B/60);
		B %= 60;

		sb.append(A >= 24 ? A % 24 : A).append(" ").append(B);

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}