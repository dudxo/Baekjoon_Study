import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        su(a,b,c);
        munjayal(a,b,c);



    }

    private static void su(int a, int b, int c) {
        System.out.println(a + b - c);
    }

    private static void munjayal(int a, int b, int c) {
        String s1 = String.valueOf(a);
        String s2 = String.valueOf(b);
        String s3 = s1 + s2;
        System.out.println(Integer.valueOf(s3) - c);
    }


}


