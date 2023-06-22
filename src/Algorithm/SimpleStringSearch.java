package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 단순 문자열 검색 알고리즘
 */
public class SimpleStringSearch {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine();      // 전체 문자열
        String s2 = br.readLine();      // 부분 문자열

        int s1Size = s1.length();
        int s2Size = s2.length();

        int count = 0;  // 일치 문자 개수

        for (int i = 0; i <= s1Size-s2Size; i++) {
            boolean flag = true;        // 일치 여부 확인
            // 부분 문자열의 맨 앞 문자가 일치하지 않으면 다음 전체 문자열 단어 확인
            for (int j = 0; j < s2Size; j++) {
                if (s1.charAt(i + j) != s2.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                count++;
            }
        }

        System.out.println("일치 단어 개수 : " + count + "개");
    }
}
