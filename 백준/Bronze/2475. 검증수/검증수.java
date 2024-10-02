import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];
        for(int i = 0; i < 5; i++) {
            arr[i] = sc.nextInt();
        }

        int sum = Arrays.stream(arr).map(e -> e * e).sum();
        System.out.println(sum % 10);

    }

}


