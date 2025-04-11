import java.io.*;
import java.util.*;

public class Main {

	static int T, N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str;

		T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			str = new StringTokenizer(br.readLine());
			N = Integer.parseInt(str.nextToken());
			M = Integer.parseInt(str.nextToken());

			bw.write(gcd(N, M) + "\n");
		}

		bw.flush();
	}

	private static int gcd(int n, int m) {
		while(m != 0) {
			int tmp = n % m;
			n = m;
			m = tmp;
		}

		return n;
	}

}