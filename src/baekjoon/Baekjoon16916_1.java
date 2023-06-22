package baekjoon;

import java.io.*;


/**
 * 백준 16916문제
 * 27% 시간 초과
 */
public class Baekjoon16916_1 {

   static void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder s1 = new StringBuilder(br.readLine());
        StringBuilder s2 = new StringBuilder(br.readLine());
        StringBuilder s3 = new StringBuilder();
        StringBuilder sol = new StringBuilder();

        int s1Size = s1.length();
        int s2Size = s2.length();
        String s2info = s2.toString();
        for (int i = 0; i <= s1Size-s2Size; i++) {
            if (s1Size >= i + s2Size) {
                s3.setLength(0);
                sol.setLength(0);
                s3.append((s1.substring(i, s2Size + i)));
                if (s3.toString().equals(s2info) == false) {
                    sol.append(0);
                } else {
                    sol.append(1);
                    break;
                }
            }
        }
        br.close();
        System.out.print(sol);
    }

    public static void main(String[] args) throws IOException {
       new Baekjoon16916_1().solution();
    }
}