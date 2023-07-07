package baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 백준5397 키로거
 * 미해결
 * 25% 틀렸습니다.
 * 올라온 반례들은 다 맞는데 왜 안되는지 이해가 안됨 안됨 안됨ㅎ
 */
public class Baekjoon5397 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());    // 테스트 케이스 개수

        LinkedList<String> st_pw = new LinkedList<String>();        // 훔친 비밀번호를 담을 지역변수 st_pw


        while (T != 0) {        // 테스트 케이스만큼 반복
            int location = 1;       // 커서 위치 1로 지정
            String pw = br.readLine();      // passWard 입력
            String[] pw2 = pw.split("");        // 입력된 passWard 쪼개기
            st_pw.clear();
            for(int i = 0; i < pw2.length; i++){        // passWard 길이만큼 반복
                if (pw2[i].equals("<")) {       // "<" 일 때
                    if (location > 1) {     // 커서가 왼쪽으로 이동할 수 있는 위치라면
                        location--;     // 왼쪽으로 한 칸 이동
                    }
                }
                else if (pw2[i].equals(">")) {      // ">" 일 때
                    if (location < st_pw.size() + 1) {      // 현재 복사된 st_pw 길이보다 작으면
                        // location은 1부터 시작하기 때문에 size()+1
                        location++;     // 오른쪽으로 한 칸 이동
                    }
                }
                else {
                    if (pw2[i].equals("-")) {       // "-" 일 때
                        if (!st_pw.isEmpty() && location > 1) {     // st_pw가 공백이 아니고 커서 위치가 맨 처음이 아닐 때
                            if (location - 1 == st_pw.size()) {
                                /* 또한 현재 커서 위치-1이 st_pw 크기와 같다면
                                한 글자만 st_pw에 있는것과 같다 */
                                st_pw.removeLast();     // 제일 마지막 삭제하고
                                location--;     // 커서 위치 맨 처음으로 초기화
                            } else {
                                st_pw.remove(location-2);       // 커서 전 위치에 있는 문자를 지워야되니 커서위치-2값을 지운다
                                location--;     // 왼쪽으로 한 칸 이동
                            }
                        }
                    }
                    else {      // 이외 문자
                        if (location > st_pw.size() + 1) {      // 커서위치가 맨 끝이라면
                            st_pw.add(location - 2, pw2[i]);        // 커서 위치-2 자리에 넣고
                        } else {
                            st_pw.add(location - 1, pw2[i]);        // 맨 끝이 아닌 처음 또는 중간이라면 커서 위치-1 자리에 넣는다
                            location++;     // 커서 오른쪽으로 이동
                        }
                    }
                }
            }

            ArrayList<String> sol = new ArrayList<>(st_pw);    // get의 시간복잡도가 O(1)인 ArrayList로 변환
            for (int i = 0; i<sol.size(); i++) {
                bw.write(sol.get(i));       // sol.get
            }
            bw.flush();
            bw.newLine();
            T--;        // 다음 테스트로 이동을 위한 후위감소식
        }
        bw.close();

    }
}
