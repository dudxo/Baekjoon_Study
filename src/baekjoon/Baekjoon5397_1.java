package baekjoon;

import java.io.*;
import java.util.LinkedList;

/**
 * 백준5397 2번째 방식
 * 23-07-01
 * not Solved
 * 시간복잡도 계산필요
 */
public class Baekjoon5397_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        LinkedList<String> st_pw = new LinkedList<>();


        while (T != 0) {
            int location = 0, left = 0;
            String tmp = "";
            String pw = br.readLine();
            for (int i = 0; i < pw.length(); i++) {
                st_pw.add(i, String.valueOf(pw.charAt(i)));
            }
            int len = st_pw.size();
            for (int k = 0; k < len; k++) {
                if (st_pw.indexOf("<") != -1) {
                    left = st_pw.indexOf("<");
                    st_pw.remove(left);
                   if(!(st_pw.get(left+1).equals("<")) || !(st_pw.get(left+1).equals(">"))) {
                       tmp = st_pw.get(left);
                       st_pw.remove(st_pw.get(left));
                       st_pw.add(location, tmp);
                   }
//                    location = left -1;
                } else if (st_pw.indexOf(">") != -1) {
                    st_pw.remove(st_pw.indexOf(">"));
                    if (location < k) {
                        location++;
                    }
                } else if (st_pw.indexOf("-") != -1) {
                    st_pw.remove(st_pw.indexOf("-"));
                    System.out.println(location);
                    st_pw.remove(location - 1);
                } else {
                    location++;
                }
                System.out.println(k +"번 : " + st_pw);
            }
            T--;
        }

    }
}
