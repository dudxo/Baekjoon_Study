import java.util.Scanner;

public class Main {

    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        movie(N);
    }
    private static void movie(int N) {
        int end = 666;
        int count = 1;

        while(count != N) {
            end += 1;
            if(String.valueOf(end).contains("666")) {
                count += 1;
            }
        }

        System.out.println(end);
    }

}