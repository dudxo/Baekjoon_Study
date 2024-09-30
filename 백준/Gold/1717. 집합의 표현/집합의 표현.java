import java.io.*;
import java.util.Scanner;

public class Main {

    private static int[] arr;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        arr = new int[n+1];

        for(int i = 0; i <= n; i++) {
            arr[i] = i;
        }

        for(int i = 0; i < m; i++) {
            int cmd = sc.nextInt();
            int a = sc.nextInt();
            int b= sc.nextInt();
            if(cmd == 0) {
                union(a, b);
            } else {
                if(check(a, b)) {
                    System.out.println("YES");
                } else{
                    System.out.println("NO");
                }
            }
        }
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a != b) {
            arr[b] = a; // 대표노드 값으로 변경
        }
    }

    private static int find(int i) {
        if(i == arr[i]) {  // 대표노드 일 때 return
            return i;
        }
        else {
            return arr[i] = find(arr[i]);  // 대표노드가 아니라면 대표노드 값으로 바꾸기
        }
    }

    private static boolean check(int a, int b) {
        a = find(a);
        b = find(b);
        if(a == b) {
            return true;
        } else {
            return false;
        }
    }

}
