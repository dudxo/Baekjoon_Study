import java.io.*;
import java.util.Scanner;

public class Main {

    private static int[] coin;
    private static int money;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        coin = new int[sc.nextInt()];
        money = sc.nextInt();

        for(int i = 0; i < coin.length; i++) {
            coin[i] = sc.nextInt();
        }

        int count =0;

        for(int i = coin.length - 1; i >= 0; i--) {
            if (coin[i] <= money) {
                count += (money / coin[i]);
                money = money % coin[i];
            }
        }
        System.out.println(count);

    }

}
