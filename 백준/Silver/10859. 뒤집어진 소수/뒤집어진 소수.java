import java.io.*;
import java.util.*;

public class Main {

	static long N, result, len;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer str;

		String st = br.readLine();

		if(Long.parseLong(st) != 1 && isMirrorNum(st)) {
			StringBuilder mirror = new StringBuilder();
			for(long i = st.length()-1; i >= 0; i--) {
				long num = Long.parseLong(String.valueOf(st.charAt((int)i)));

				if(num == 6) num = 9;
				else if(num == 9) num = 6;

				mirror.append(num);
			}

			long mirrorNum = Long.parseLong(mirror.toString());

			if(isPrime(Long.parseLong(st)) && isPrime(mirrorNum)) sb.append("yes");
			else sb.append("no");
		} else {
			sb.append("no");
		}


		bw.write(sb.toString());
		bw.flush();
	}

	private static boolean isPrime(long mirrorNum) {
		for(long i = 2; i <= Math.sqrt(mirrorNum); i++) {
			if(mirrorNum % i == 0) {
				return false;
			}
		}
		return true;
	}

	private static boolean isMirrorNum(String st) {
		for(long i = 0; i < st.length(); i++) {
			long num = Long.parseLong(String.valueOf(st.charAt((int)i)));
			if(num == 3 || num == 4 || num == 7) return false;
		}

		return true;
	}

}