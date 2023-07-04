package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 백준10158 개미
 * 미완성
 * 시간복잡도 고려하기!
 */
public class Baekjoon10158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        int w = 0, h = 0, p = 0, q = 0, time = 0, pre_p = 0, pre_q = 0;
        w = sc.nextInt();
        h = sc.nextInt();
        p = sc.nextInt();
        q = sc.nextInt();
        time = sc.nextInt();

        for (int k = 0; k < time; k++) {
            // 이전 경로 저장
            pre_p = p;
            pre_q = q;

            // 경로 이동
            if (w == p) {      // p가 w일 때
                if (pre_q> q) {
                    p--;
                    q--;
                } else {
                    p--;
                    q++;
                }
            } else if (h == q) {        // q가 h일 때
                if (pre_p > p) {
                    p--;
                    q--;
                } else {
                    p++;
                    q--;
                }
            } else {
                p++;
                q++;
            }
            System.out.println(k + "번 째: " + p + " " + q);
        }

    }
}
