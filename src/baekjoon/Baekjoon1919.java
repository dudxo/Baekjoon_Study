package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준1919 애너그렘 만들기
 * 강의 영상 참고
 * 24행, 27행을 활용할 수 있도록 노력 필요.
 * Sol
 */
public class Baekjoon1919 {
    public static void main(String[] args) throws IOException {
        BufferedReader bw = new BufferedReader(new InputStreamReader(System.in));

        String a = bw.readLine();
        String b = bw.readLine();

        int[] a1 = new int[26];
        int[] b1 = new int[26];

        for (int i = 0; i < a.length(); i++) {
            a1[a.charAt(i) - 'a']++;        // 알파벳 순으로 값 저장
        }
        for (int i = 0; i < b.length(); i++) {
            b1[b.charAt(i) - 'a']++;        // 알파벳 순으로 값 저장
        }

        int ans = 0;
        for (int k = 0; k < 26; k++) {
            // a1[k]와 b1[k]의 값 즉 알파벳 개수가 다르면 다른 만큼 제거
            if (a1[k] != b1[k]) {
                if (a1[k] - b1[k] > 0) {
                    ans += a1[k] - b1[k];
                } else {
                    ans += ((a1[k] - b1[k]) * -1);
                }
            }
        }

        System.out.println(ans);
    }
}
