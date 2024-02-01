import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int P = sc.nextInt();
        Stack<Integer>[] stack = new Stack[N];
        int count = 0;

        for (int a = 0; a < N; a++) {
            stack[a] = new Stack<Integer>();
        }

        for (int i = 1; i <= N; i++) {
            int n = sc.nextInt();
            int p = sc.nextInt();
            if (stack[n].size() == 0) {
                stack[n].push(p);
                count++;
                continue;
            }

            while (!stack[n].isEmpty() && stack[n].peek() > p) {
                stack[n].pop();
                count++;
            }

            if (stack[n].size() !=0 && stack[n].peek() == p) {
                continue;
            }
            stack[n].push(p);
            count++;
        }
        System.out.println(count);
    }
}
