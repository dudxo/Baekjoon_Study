package baekjoon;

import java.io.*;


/**
 * 백준 16916문제
 * 27% 시간 초과
 */
public class Baekjoon16916_2 {

    static StringBuilder solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder s1 = new StringBuilder(br.readLine());
        StringBuilder s2 = new StringBuilder(br.readLine());
        StringBuilder sol = new StringBuilder();

        int s1Size = s1.length();
        int s2Size = s2.length();
        String s2info = s2.toString();
        for (int i = 0; i <= s1Size-s2Size; i++) {
            boolean flag = true;
            for (int j = 0; j < s2Size; j++) {
                if (s1.charAt(i + j) != s2.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                sol.append(1);
                return sol;
            }
        }
        sol.append(0);
        return sol;
    }

    public static void main(String[] args) throws IOException {
        System.out.print(Baekjoon16916_2.solution());
    }
}