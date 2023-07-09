import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int A =0, B = 0;
        A = sc.nextInt();
        B = sc.nextInt();

        System.out.println((double) A/B);
    }

}
