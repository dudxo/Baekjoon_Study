import java.io.*;
import java.util.Scanner;

public class Main {

    private static int[] arr, route;
    private static int[][] city;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        arr = new int[n+1];
        city = new int[n+1][n+1];

        for(int i = 1; i <= n; i++) {
            arr[i] = i;
            for(int j = 1; j <= n; j++) {
                city[i][j] = sc.nextInt();
            }
        }
        route = new int[m+1];
        for(int i = 1; i <= m; i++) {
            route[i] = sc.nextInt();
        }

        for(int i = 1; i <= n; i++) {
            for(int j = i; j <= n; j++) {
                if(city[i][j] == 1) {
                    union(i, j);
                }
            }
        }
        if(check(route)) {
            System.out.println("YES");
        } else{
            System.out.println("NO");
        }
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a != b) {
            arr[b] = a;
        }
    }

    private static int find(int i) {
        if(i == arr[i]) {
            return i;
        } else {
            return arr[i] = find(arr[i]);
        }
    }

    private static boolean check(int[] route) {
        int answer = find(route[1]);
        for(int i = 2; i < route.length; i++) {
            if(answer != find(route[i])) {
                return false;
            }
        }
        return true;
    }

}


