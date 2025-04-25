import java.io.*;
import java.util.*;
public class Main {

	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());

		int sum = 0;
		for(int i = 1; i <= N; i++) {
			sum += i;
		}

		sb.append(sum);

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}