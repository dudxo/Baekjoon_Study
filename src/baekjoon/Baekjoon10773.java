package baekjoon;

import java.io.*;
import java.util.Stack;

/**
 * 시간제한 1초, 입력값의 범위 1~100,000
 * O(NlogN)이하 알고리즘 설계
 */
public class Baekjoon10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = 0, sol = 0;
        T = Integer.parseInt(br.readLine());
        java.util.Stack<Integer> stack =new Stack<>();

        while (T-- > 0) {
            int money = 0;
            money = Integer.parseInt(br.readLine());
            if (money != 0) {
                stack.push(money);
            } else {
                stack.pop();
            }
        }

        while (!stack.isEmpty()) {
            sol += stack.pop();
        }
        bw.write(Integer.toString(sol));
        bw.flush();
        bw.close();
    }

}
