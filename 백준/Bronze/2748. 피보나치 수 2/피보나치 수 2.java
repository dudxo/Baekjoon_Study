import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static long N, result ;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer str;

		N = Integer.parseInt(br.readLine());

		sol(0, 1, 0);
		sb.append(result);

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static void sol(long a, long b, int depth) {
		if(depth == N) {
			result = a;
			return;
		}

		sol(b, a+b, depth+1);
	}
}
