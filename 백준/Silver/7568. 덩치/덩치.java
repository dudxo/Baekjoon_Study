import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int N;
    static List<Integer>[] bodies;
    static int[] rank;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        bodies = new ArrayList[N];
        for(int i = 0; i < N; i++) {
            bodies[i] = new ArrayList<>();
        }
        rank = new int[N];

        for(int i = 0; i < N; i++) {
            int weight = sc.nextInt();
            int height = sc.nextInt();
            bodies[i].add(weight);
            bodies[i].add(height);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            int result = rank(i);
            sb.append(result+1).append(" ");
        }

        System.out.print(sb);
    }

    private static int rank(int i) {
        int big = 0;
        int weight = bodies[i].get(0);
        int height = bodies[i].get(1);

        for(int j = 0; j < N; j++) {
            if(j == i) {
                continue;
            }
            if(bodies[j].get(0) > weight && bodies[j].get(1) > height) {
                big += 1;
            }
        }

        return big;
    }
}