package baekjoon;

import java.io.*;


/**
 * 백준 16916문제
 * 27% 시간 초과
 * 단순 문자열 알고리즘 사용
 */
public class Baekjoon16916_6 {

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
                if (s1.charAt(i + j) != s2.charAt(j)) {     // 앞에 있는 문자가 맞지 않으면 넘어가는 로직
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
        System.out.print(Baekjoon16916_6.solution());
    }
}