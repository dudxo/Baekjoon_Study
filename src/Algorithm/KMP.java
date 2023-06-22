package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KMP {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String parent = br.readLine();
        String pattern = br.readLine();
        kmp(parent, pattern);
    }

    static void kmp(String parent, String pattern) {
        int[] makeTable = table(pattern);       // 테이블(실패 함수)
        char[] parents = parent.toCharArray();      // 전체 문자열
        char[] patterns = pattern.toCharArray();    // 부분 문자열

        int k = 0;
        for (int i = 1; i < parents.length; i++) {
            // k가 0보다 크고 전체 문자열의 문자와 패턴 문자열의 문자가 다르면
            // k를 직전 위치로 이동
            while (k > 0 && parents[i] != patterns[k]) {
                k = makeTable[k - 1];
            }
            // 둘의 문자가 같을 때
            // k가 패턴 문자열의 길이와 같으면 일치  == 패턴 문자열 처음부터 끝까지 같으면 문자열 일치
            // 다르면 k 값을 증가시켜 접두사까지 확인
            if (parents[i] == patterns[k]) {
                if(k == patterns.length - 1) {
                    System.out.printf("%d 번째에서 찾았습니다.\n", i - patterns.length + 2);
                    k = makeTable[k];
                }
                else {
                    k++;
                }
            }
        }
    }

    static int[] table(String pattern) {        // 접두사, 접미사 일치 테이블 메서드
        char[] patterns = pattern.toCharArray();
        int[] table = new int[patterns.length];
        int k = 0;

        for (int i = 1; i < patterns.length; i++) {
            while (k > 0 && patterns[i] != patterns[k]) {       // 접미사와 접두사가 일치하지 않으면
                k = table[k - 1];  // 직전 위치까진 일치했기 때문에 효율을 생각해 바로 전으로 이동
            }
            if(patterns[i] == patterns[k]){     // 접미사와 접두사가 일치하면
                table[i] = ++k;  // 일치한 개수만큼 넣기 == 일치한 길이
            }
        }

        return table;
    }
}
