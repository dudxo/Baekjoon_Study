package baekjoon;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 백준5397 3번째방식
 * 23-07-01
 * not Solved
 * 시간복잡도 계산 필요
 *
 */
public class Baekjoon5397_2 {
    public static void main(String[] args) throws IOException {
        long strat = System.currentTimeMillis();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        int location;

        while (T > 0) {
            location = 1;
            List<String> st_pw = new LinkedList<>();

            String pw = br.readLine();
            String[] pw2 = new String[pw.length()];
            int len_pw = pw2.length;
            int len_st_pw;
            bw.newLine();

            for(int i = 0; i < len_pw; i++){
                pw2[i] = pw.substring(i, i + 1);
                len_st_pw = st_pw.size();
                switch (pw2[i]) {
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
                        if (!st_pw.isEmpty() && location > 1) {
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
                            st_pw.add(location - 2, pw2[i]);
                        } else {
                            st_pw.add(location - 1, pw2[i]);
                            location++;
                        }
                }
            }

            Iterator<String> it = st_pw.iterator();
            while (it.hasNext()) {
                bw.write(it.next());
            }
            T--;
        }
        long end = System.currentTimeMillis();
        System.out.println("시간 : " + (end-strat)/1000);
        bw.flush();
        bw.close();
    }
}

