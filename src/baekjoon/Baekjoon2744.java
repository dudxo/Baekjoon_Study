package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String reverse_s = "";

        int s_len = s.length();     // 호출을 줄이기 위한 문자열 s 길이 변수 선언

        for (int i = 0; i < s_len; i++) {
            if (s.charAt(i) >= 65 && s.charAt(i) <=90) {      // 대문자 확인
                // 해당 문자 소문자로 변경
                reverse_s = reverse_s + String.valueOf(s.charAt(i)).toLowerCase();
            }
            if(s.charAt(i)>=97 && s.charAt(i) <= 122){        // 소문자 확인
                // 해당 문자 대문자로 변경
                reverse_s = reverse_s + String.valueOf(s.charAt(i)).toUpperCase();
            }
        }
        br.close();
        System.out.println(reverse_s);
    }
}
