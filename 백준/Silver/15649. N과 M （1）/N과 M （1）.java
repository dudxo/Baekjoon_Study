import java.util.Scanner;

public class Main {

    static int n, m;
    static int[] arr;
    static boolean[] isUsed;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[m+1];
        isUsed = new boolean[n+1];
        back(0);
    }

    private static void back(int k) {
        if(k==m) {
            for(int i = 0; i < m; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }
        for(int i = 1; i <= n; i++) {
            if(!isUsed[i]) {
                arr[k] = i;
                isUsed[i] = true;
                back(k+1);
                isUsed[i] = false;
            }
        }
    }

}