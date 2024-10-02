import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        char[] chars = String.valueOf((A * B * C)).toCharArray();
        int [] cnt = new int[10];
        for(char c : chars) {
            cnt[(int) c - 48]++;
        }
        for(int i : cnt) {
            System.out.println(i);
        }
    }



}


