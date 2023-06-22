package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 10820
 * Sol
 */

public class Baekjoon10820 {
    public static void main(String[] args) throws IOException {
        String s = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        while (s != null){
            int num1 = 0, num2 =0, num3 = 0, num4 = 0;

            for (int i = 0; i < s.length(); i++) {
                if (Character.isUpperCase(s.charAt(i)))      // 대문자면 true
                    num2++;     // 대문자
                else if (Character.isLowerCase(s.charAt(i)))     // 소문자면 true
                    num1++;     // 소문자
                else if (s.charAt(i) == ' ')
                    num4++;     // 공백
                else if (Character.isDigit(s.charAt(i)))
                    num3++;     // 숫자
            }
            System.out.println(num1 + " " + num2 + " " + num3 + " " + num4);
            s = br.readLine();
        }
    }
}
