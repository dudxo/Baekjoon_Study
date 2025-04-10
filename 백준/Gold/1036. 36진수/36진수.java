import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

	static int N, K;
	static Node[] bases;
	static Map<String, Integer> changeBaseMap;

	static class Node implements Comparable<Node> {
		int base, count;
		BigInteger sub;

		Node(int base, int count, BigInteger sub) {
			this.base = base;
			this.count = count;
			this.sub = sub;
		}

		public int compareTo(Node o) {
			return o.sub.compareTo(this.sub);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer str;

		N = Integer.parseInt(br.readLine());
		List<String> list = new ArrayList<>();
		changeBaseMap = new HashMap<>();
		bases = new Node[36];

		for(int i = 0; i < 36; i++) {
			bases[i] = new Node(i, 0, BigInteger.ZERO);
		}

		String st = "";
		for(int i = 0; i < N; i++) {
			st = br.readLine().trim();

            for(int j = 0; j < st.length(); j++) {
				BigInteger integer = new BigInteger(String.valueOf(st.charAt(j)), 36);
				int base = Integer.parseInt(String.valueOf(integer));

				int tmp = st.length()-j-1;

				BigInteger sub = BigInteger.ZERO;
				if(tmp == 0) sub = BigInteger.valueOf(35 - base);
				else sub = BigInteger.valueOf(35 - base).multiply(BigInteger.valueOf(36).pow(tmp));

				bases[base] = new Node(base, Math.max(bases[base].count, tmp), (bases[base].sub.add(sub)));
			}

			list.add(st);
		}
		Arrays.sort(bases);

		K = Integer.parseInt(br.readLine());
		for(int i = 0; i < K; i++) {
			Node node = bases[i];
			if(i == 35 && node.base == 35) break;
			if(node.base == 35) {
				i--;
				continue;
			}

			changeBaseMap.put(Integer.toString(node.base, 36).toUpperCase(), node.base);
		}

		BigInteger sum = BigInteger.ZERO;
		// Z로 변경하며 더하기
		for(String s : list) {
			StringBuilder sb2 = new StringBuilder();
			for(int i = 0; i < s.length(); i++) {
				if(changeBaseMap.containsKey(String.valueOf(s.charAt(i)))) {
					sb2.append("Z");
					continue;
				}
				sb2.append(s.charAt(i));
			}

			BigInteger integer = new BigInteger(sb2.toString(), 36);
			sum = sum.add(integer);
		}

		sb.append(sum.toString(36));

		bw.write(sb.toString().toUpperCase());
		bw.flush();
	}



}