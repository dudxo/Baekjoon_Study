import java.io.*;
import java.util.*;

public class Main {
	static boolean[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer str;

		arr = new boolean[31];

		int count = 28;
		while(count-- > 0) {
			int num = Integer.parseInt(br.readLine());
			arr[num] = true;
		}

		for(int i = 1; i <= 30; i++) {
			if(!arr[i]) {
				sb.append(i).append("\n");
			}
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}


}