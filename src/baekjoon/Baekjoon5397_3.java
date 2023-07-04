package baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * 백준5397 4번째방식
 * 23-07-4
 * Sol
 * 시간복잡도 O(n)
 */
public class Baekjoon5397_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            LinkedList<Character> pw = new LinkedList<>();      // 원본 비밀번호가 담길 리스트
            ListIterator<Character> iter = pw.listIterator();       // list 반복자 복사
            String input = br.readLine();        // 원본 비밀번호

            // 입력한 패스워드 문자마다 확인
            for (int i = 0; i < input.length(); i++) {
                char check = input.charAt(i);
                switch (check) {
                    case '<':       // 왼쪽 키일 때
                        if (iter.hasPrevious()) {       // 역방향으로 순회해 다음 요소가 있다면 true
                            iter.previous();        // 커서 왼쪽으로 한칸 이동
                        }
                        break;
                    case '>':       // 오른쪽 키일 때
                        if (iter.hasNext()) {       // 순방향으로 순회해 다음 요소가 있다면 true
                            iter.next();        // 커서 오른쪽으로 한칸 이동
                            /*.next() 메소드 사용 시 원본 리스트 값을 수정하면 멀티 쓰레드 환경에서 값이 변경 되어 오류가 발생함*/
                        }
                        break;
                    case '-':       // BackSpace 키일 때
                        if (iter.hasPrevious()) {       // 역방향으로 순회해 다음 요소가 있을 때
                            iter.previous();        // 커서를 이전(역방향 순회)
                            iter.remove();      // 삭제
                        }
                        break;
                    default:
                        iter.add(check);        // 문자 추가(복사)
                }

            }

            for (char sol : pw) {       // 버퍼에 문자열(복사 패스워드) 담기
                bw.write(sol);
            }
            bw.newLine();       // 여러 케이스를 나눌 라인(개행)추가
        }
        bw.flush();     // flush
    }
}
