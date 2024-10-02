import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int H = sc.nextInt();
        int M = sc.nextInt();
        calculateTime(H, M);
    }

    private static void calculateTime(int H, int M) {
        M -= 45;

        if(M < 0) {
            if(H == 0) {
                H = 23;
            } else {
                H -= 1;
            }
            M = 60 + M;
        }
        System.out.println(H + " " + M);
    }


}


