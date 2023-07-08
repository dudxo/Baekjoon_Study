package baekjoon;

import java.io.*;
import java.util.Stack;

/**
 * 시간제한 1초, 문자열의 길이는 2이상 50이하
 */
public class Baekjoon9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = 0;
        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String PS = "", sol = "";
            int len = 0;
            Stack<Character> stack = new Stack<>();

            PS = br.readLine();
            len = PS.length();

            for (int i = 0; i < len; i++) {
                switch (PS.charAt(i)) {
                    case '(':
                        stack.push(PS.charAt(i));
                        break;
                    case ')':
                        if (!stack.isEmpty() && stack.peek() == '(') {
                            stack.pop();
                        }
                        else {
                            stack.push(PS.charAt(i));
                        }

                        break;
                }
            }
            if (stack.isEmpty()) {
                sol = "YES";
            } else {
                sol = "NO";
            }
            bw.write(sol);
            bw.newLine();
            bw.flush();
        }
        bw.close();
    }
}