package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준14405 2번째 방식
 * ======================
 * 23-06-28 14시경
 * 55% 런타임에러(StringIndexOutOfBounds)  * 해결
 * 배열 범위 계산 필요
 * ======================
 * 23-06-29 01:06 Sol
 * 최적화 필요
 */
public class Baekjoon14405_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();

        pikachu(S);
    }

    static void pikachu(String S) {
        int S_size = S.length();
        boolean flag = true;
        for (int i = 0; i < S_size;) {
            // 해당 문자의 앞 글자 확인 및 길이 확인
            // 그 다음 해당 문자의 뒷 글자들 확인
            if (i < S_size-1 && S.charAt(i) == 'p') {
                if (S.charAt(i + 1) != 'i') {
                    flag = false;
                    break;
                }
                i += 2;
            } else if (i < S_size-1 && S.charAt(i) == 'k') {
                if (S.charAt(i + 1) != 'a') {
                    flag = false;
                    break;
                }
                i +=2;
            } else if (i < S_size-2 && S.charAt(i) == 'c') {
                if (S.charAt(i + 1) != 'h') {
                    flag = false;
                    break;
                } else if (S.charAt(i + 2) != 'u') {
                    flag = false;
                    break;
                }
                i += 3;
            } else {
                flag = false;
                break;
            }
        }

        if (flag == true) {
            System.out.print("YES");
        } else {
            System.out.print("NO");
        }
    }
}
