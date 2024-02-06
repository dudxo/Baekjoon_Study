import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int count = 0;
        Set<String> set = new HashSet<>();
        List<String> list = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            set.add(sc.next());
        }

        for (int a = 0; a < M; a++) {
            list.add(sc.next());
        }

        for (String s : list) {
            if (set.contains(s)) {
                count++;
            }
        }

        System.out.println(count);
    }
}
