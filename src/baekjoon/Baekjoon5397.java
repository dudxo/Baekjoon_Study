package baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

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
        int T = Integer.parseInt(br.readLine());
        LinkedList<String> st_pw = new LinkedList<String>();


        while (T != 0) {
            int location = 1;
            String pw = br.readLine();
            String[] pw2 = pw.split("");
            st_pw.clear();
            for(int i = 0; i < pw2.length; i++){
                if (pw2[i].equals("<")) {
                    if (location > 1) {
                        location--;
                    }
                }
                else if (pw2[i].equals(">")) {
                    if (location < st_pw.size() + 1) {
                        location++;
                    }
                }
                else {
                    if (pw2[i].equals("-")) {
                        if (!st_pw.isEmpty() && location > 1) {
                            if (location - 1 == st_pw.size()) {
                                st_pw.removeLast();
                                location--;
                            } else {
                                st_pw.remove(location-2);
                                location--;
                            }
                        }
                    }
                    else {
                        if (location > st_pw.size() + 1) {
                            st_pw.add(location - 2, pw2[i]);
                        } else {
                            st_pw.add(location - 1, pw2[i]);
                            location++;
                        }
                    }
                }
            }

            ArrayList<String> sol = new ArrayList<>(st_pw);
            for (String pr : sol) {
                bw.write(pr);
            }
            bw.flush();
            bw.newLine();
            T--;
        }
        bw.close();

    }
}
