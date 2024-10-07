import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    private static ArrayList<Integer>[] arr;
    private static int[] degree;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        arr = new ArrayList[N + 1];
        degree = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            arr[A].add(B);
            degree[B]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (degree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int i = queue.poll();
            System.out.print(i + " ");
            for (int j : arr[i]) {
                degree[j]--;
                if (degree[j] == 0) {
                    queue.offer(j);
                }
            }
        }

    }


}