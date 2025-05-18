import java.io.*;
import java.util.*;

public class Main {

	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer str;

		String s = br.readLine();

		for(int i = s.length()-1; i >= 0; i--) {
			sb.append(s.charAt(i));
		}

		bw.write(s.equals(sb.toString()) ? "1" : "0");

		// bw.write(sb.toString());
		bw.flush();
		bw.close();
	}


}