package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준1919 애너그램 만들기
 * 2% 틀렸습니다.
 */
public class Baekjoon1919_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine();
        String s2 = br.readLine();

        int s1_len = s1.length();
        int s2_len = s2.length();
        int count = 0;

        for (int i = 0; i < s1_len; i++) {
            for (int j = 0; j < s2_len; j++) {
                if (s1.charAt(i) == s2.charAt(j)){
                    count ++;
                    break;
                }
            }
        }

        for (int i = 0; i < s1_len; i++) {
            for (int j = 0; j < s2_len; j++) {
                if (s2.charAt(i) == s1.charAt(j)){
                    count ++;
                    break;
                }
            }
        }

        System.out.print((s1_len+s2_len-count));
    }
}
