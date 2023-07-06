package baekjoon;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 백준5397_4번째 방식
 * not Solved
 * 시간복잡도 문제
 */
public class Baekjoon5397_4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        int location;       // 커서 위치

        while (T > 0) {     // O(N)
            location = 1;
            List<String> st_pw = new LinkedList<>();        // 뺏은 비밀번호
            String pw = br.readLine();      // 원래 비밀번호
            sol(pw, st_pw, location);

            Iterator<String> it = st_pw.iterator();
            while (it.hasNext()) {
                bw.write(it.next());
            }
            bw.newLine();
            T--;
        }
        bw.flush();
        bw.close();
    }
    static void sol(String pw, List<String> st_pw, int location) {
        int len_pw = pw.length();
        int len_st_pw;

        for(int i = 0; i < len_pw; i++){        // O(N)
            len_st_pw = st_pw.size();       // 현재 복사한 입력값 크기
            switch (pw.substring(i, i   + 1)) {       // 단어 확인
                case "<":
                    if (location > 1) {
                        location --;
                    }
                    break;
                case ">":
                    if (location < len_st_pw + 1) {
                        location++;
                    }
                    break;
                case "-":
                    if (location > 1) {
                        if (location - 1 == len_st_pw) {
                            st_pw.remove(len_st_pw-1);
                            location--;
                        } else {
                            st_pw.remove(location-2);
                            location--;
                        }
                    }
                    break;
                default:
                    if (location > len_st_pw + 1) {
                        st_pw.add(location - 2, pw.substring(i, i   + 1));
                    } else {
                        st_pw.add(location - 1, pw.substring(i, i   + 1));
                        location++;
                    }
            }
        }

    }
}
