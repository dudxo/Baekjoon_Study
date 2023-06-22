package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 백준 16916문제
 * 27% 시간 초과
 */
public class Baekjoon16916_4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder s1 = new StringBuilder(br.readLine());
        StringBuilder s2 = new StringBuilder(br.readLine());
        StringBuilder s3 = new StringBuilder();
        StringBuilder sol = new StringBuilder("0");

        int s1Size = s1.length();
        int s2Size = s2.length();

        for(int i =0; i< s1Size; i++) {
            if (s1.length() >= i + s2Size) {
                s3.append((s1.substring(i, s2Size + i)) + " ");
            }
        }

        StringTokenizer st = new StringTokenizer(s3.toString(), " ");

        while(st.hasMoreTokens()) {
            if (st.nextToken().equals(s2.toString())) {
                sol.setLength(0);
                sol.append(1);
            }
        }
        System.out.print(sol.toString());
        br.close();
    }
}
