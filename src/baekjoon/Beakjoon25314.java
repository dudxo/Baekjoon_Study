package baekjoon;

import java.util.Scanner;

/**
 * 백준25314 코딩은 체육과목 입니다.
 * sol
 */
public class Beakjoon25314 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int num = N / 4;

        for (int i = 0; i < num; i++) {
            System.out.print("long ");
        }
        System.out.print("int");
    }
}
