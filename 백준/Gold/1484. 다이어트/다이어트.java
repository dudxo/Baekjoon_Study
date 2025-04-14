import java.io.*;
import java.util.*;

public class Main {

	static int G;
	static List<Integer> result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer str;

		G = Integer.parseInt(br.readLine());
		result = new ArrayList<>();

		for(int i = 1; i * i < G; i++) {
			if(G % i == 0) {
				int a = i;
				int b = G / i;
				if((a+b) % 2 == 0) {
					result.add((a+b) / 2);
				}
			}
		}

		if(result.isEmpty()) result.add(-1);

		Collections.sort(result);
		for(int i : result) {
			sb.append(i).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}


}