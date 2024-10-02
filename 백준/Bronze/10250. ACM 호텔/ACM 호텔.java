import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0; i < T; i++) {
            int H = sc.nextInt();
            int W = sc.nextInt();
            int N = sc.nextInt();
            assignRoom(H,W,N);

        }
    }

    private static void assignRoom(int H, int W, int N) {
        int count = 1;
        for(int i = 0; i < W; i++) {
            for(int j = 0; j < H; j++) {
                if(count == N) {
                    if(i+1 > 9) {
                        System.out.printf("%d%2d\n", j + 1, i + 1);
                    } else {
                        System.out.printf("%d0%d\n", j + 1, i + 1);
                    }
                }
                count++;
            }
        }
    }

}


