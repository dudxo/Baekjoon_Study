package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 16916 부분 문자열
 * KMP 알고리즘 사용  * 시간 복잡도 O(N * M)  * N = 전체 문자열 길이, M = 패턴 문자열 길이
 * Sol
 */
public class Baekjoon16916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // BufferedReader를 사용해 최적화
        String parent = br.readLine();      // 전체 문자열 입력
        String pattern = br.readLine();     // 패턴(부분) 문자열 입력

        kmp(parent, pattern);
    }

    static void kmp(String parent, String pattern) {
        char[] parents = parent.toCharArray();      // 전체 문자열
        char[] patterns = pattern.toCharArray();    // 패턴 문자열
        int[] makeTable = table(pattern);

        int k = 0, check = 0;

        for (int i = 0; i < parents.length; i++) {
            // k가 0보다 크고 전체 문자열의 문자와 패턴 문자열의 문자가 다르면
            // k를 직전 위치로 이동
            while (k > 0 && parents[i] != patterns[k]) {
                k = makeTable[k - 1];
            }
            // 둘의 문자가 같을 때
            // k가 패턴 문자열의 길이와 같으면 일치  == 패턴 문자열 처음부터 끝까지 같으면 문자열 일치
            // 다르면 k 값을 증가시켜 접두사까지 확인
            if (parents[i] == patterns[k]) {
                if (k == patterns.length - 1) {
                    k = makeTable[k];
                    check = 1;
                } else {
                    k++;
                }
            }
        }
        System.out.print(check);        // 같은게 있으면 1, 하나도 없으면 0 출력
    }

    static int[] table(String pattern) {        // 접두사, 접미사 일치 테이블 메서드
        char[] patterns = pattern.toCharArray();
        int[] table = new int[patterns.length];     // 패턴 길이만큼 테이블 생성
        int k = 0;

        for (int i = 1; i < patterns.length; i++) {
            // k가 0보다 크고 k와 i의 문자가 다르면 k는 이전 문자 위치로 이동
            // 이전 문자까지는 일치했기 때문에 효율성을 생각해 처음으로 이동하지 않는다.
            while (k > 0 && patterns[i] != patterns[k]) {
                k = table[k - 1];
            }
            // k와 i의 문자가 같으면 table 값 증가
            if (patterns[i] == patterns[k]) {
                table[i] = ++k;
            }
        }

        return table;
    }


}
