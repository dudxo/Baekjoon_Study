import java.io.*;
import java.util.*;

public class Main {

	static long N, result, len;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer str;

		N = Long.parseLong(br.readLine());

		long max = 1;
		do {
			max <<= 1;
		}while(max <= N);
		max -= 1;

		if(N == max) sb.append("1").append("\n").append(max);
		else sb.append("2").append("\n").append(N ^ max).append(" ").append(N);

		bw.write(sb.toString());
		bw.flush();
	}

}