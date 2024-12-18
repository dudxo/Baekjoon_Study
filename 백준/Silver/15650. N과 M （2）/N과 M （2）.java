import java.util.Scanner;

public class Main {

    static int n, m;
    static int[] arr;
    static boolean[] isUsed;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n];
        isUsed = new boolean[n];
        back(0);
    }

    private static void back(int k) {
        if(k == m) {
            for(int i = 0; i < m; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }
        for(int i = 1; i <= n; i++) {
            if(!isUsed[i-1]) {
                if(k == 0 || arr[k-1] < i) {
                    arr[k] = i;
                    isUsed[i-1] = true;
                    back(k+1);
                    isUsed[i-1] = false;
                }
            }
        }
    }
}