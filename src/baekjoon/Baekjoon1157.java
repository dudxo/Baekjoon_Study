package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준1157 단어공부
 * Sol(1)
 */
public class Baekjoon1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int[] count = new int[26];
        str = str.toUpperCase();
        int tmp = 0;
        char result = ' ';

        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i) - 'A']++;
        }

        for (int k = 0; k < count.length; k++) {
            // 문자 개수가 가장 많은 해당 문자를, 개수가 가장 많고 동일한 문자가 있다면 ? 출력
            if (tmp < count[k]) {
                tmp = count[k];
                result = (char) ('A' + k);
            }
            else if (tmp == count[k]) {
                tmp = count[k];
                result = '?';
            }
        }
        System.out.print(result);
    }
}
