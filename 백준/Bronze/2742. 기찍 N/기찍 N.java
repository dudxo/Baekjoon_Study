	import java.io.*;
	import java.util.*;

	public class Main {

		static int N;
		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			StringBuilder sb = new StringBuilder();
			StringTokenizer str;

			N = Integer.parseInt(br.readLine());
			for(int i = N; i >= 1; i--) {
				sb.append(i).append("\n");
			}

			bw.write(sb.toString());
			bw.flush();
			bw.close();
		}
}
