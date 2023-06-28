package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준14405 피카츄
 * 알고리즘 스터디 문자열 문제
 * 23-06-29 00:55 sol
 * 최적화 필요
 */
public class Baekjoon14405 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();

        pikachu(S);

    }

    static void pikachu(String S) {
        int S_size = S.length();
        boolean flag = true;
        for (int i = 0; i < S_size;) {
            // 해당 단어의 앞 문자가 일치하는지 그리고 해당 단어의 길이만큼 남아 있는지 확인
            // 앞 문자가 일치하면 해당 단어가 맞는지 확인
            if (i < S_size-1 && S.charAt(i) == 'p') {
                if (!S.substring(i, i+2).equals("pi")) {
                    flag = false;
                    break;
                }
                i += 2;
            } else if (i < S_size-1 && S.charAt(i) == 'k') {
                if (!S.substring(i, i + 2).equals("ka")) {
                    flag = false;
                    break;
                }
                i += 2;
            } else if (i < S_size-2 && S.charAt(i) == 'c') {
                if (!S.substring(i, i + 3).equals("chu")) {
                    flag = false;
                    break;
                }
                i += 3;
            } else {
                flag = false; break;
            }
        }

        if (flag == true) {
            System.out.print("YES");
        } else {
            System.out.print("NO");
        }
    }


}