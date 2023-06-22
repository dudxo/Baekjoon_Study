package baekjoon;

import java.util.Scanner;

/**
 * 백준 2675
 * Sol
 */
public class Baekjoon2675 {
    public static void main(String[] args) {
        String s = "";
        int re = 0, num = 0;
        Scanner sc = new Scanner(System.in);


        num = sc.nextInt();
        String[] a;
        do {
            int check = 0;
            re = sc.nextInt();
            s = sc.next();

            a = new String[s.length() * re];
            for (int i = 0; i < s.length(); i++) {
                for (int j = 0; j < re; j++) {
                    a[check] = s.substring(i,i+1);      // i부터 i+1까지 문자열 자르기  * i+1번째는 포함되지 않음!
                    check++;
                }
            }

            for(int i=0; i<a.length; i++) {
                System.out.print(a[i]);
            }
            System.out.println();
            num -= 1;
        } while (num != 0);

    }
}
