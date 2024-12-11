import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    static ArrayList<Character>[] c;
    static int N, K;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        c = new ArrayList[K+1];
        for(int i = 1; i <= K; i++) {
            c[i] =  new ArrayList<Character>();
        }

        multiple(N, K);
    }
    private static void multiple(int N, int K) {
        int max = 0;
        for(int i = 1 ; i <= K; i++) {
            String mul = String.valueOf(N * i);
            for(char ch : mul.toCharArray()) {
                c[i].add(ch);
            }
            Collections.reverse(c[i]);

            int num = 0;
            int digit = 1;
            for(int j = c[i].size()-1; j >= 0; j--) {
                num += (c[i].get(j) - 48) * digit;
                digit *= 10;
            }

            if(max <= num) {
                max = num;
            }
        }

        System.out.println(max);
    }
}