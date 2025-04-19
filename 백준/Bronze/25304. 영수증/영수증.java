import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int X, N, sum;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer str;

		X = Integer.parseInt(br.readLine());
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			str = new StringTokenizer(br.readLine());
			sum += Integer.parseInt(str.nextToken()) * Integer.parseInt(str.nextToken());
		}

		if (sum == X) {
			sb.append("Yes");
		} else {
			sb.append("No");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
