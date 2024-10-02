import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        gogodan(N);
    }
    
    private static void gogodan(int N) {
        for(int i = 1; i <= 9 ; i++) {
            System.out.printf("%d * %d = %d\n", N, i, N*i);
        }
    }

}


