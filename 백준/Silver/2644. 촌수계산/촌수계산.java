import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static int n, count, h1, h2, m, x, y;
    static ArrayList<Integer>[] family;
    static boolean[] visited;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        count = 0;
        n = sc.nextInt();
        h1 = sc.nextInt();
        h2 = sc.nextInt();
        m = sc.nextInt();

        family = new ArrayList[n+1];
        visited = new boolean[n+1];

        for(int i = 1; i <= n; i++) {
            family[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i ++) {
            x = sc.nextInt();
            y = sc.nextInt();
            family[x].add(y);
            family[y].add(x);
        }

        DFS(h1, h2);

        if(count > 0) {
            System.out.println(count);
        } else {
            System.out.println(-1);
        }
    }

    private static boolean DFS(int i, int j) {
        if(visited[i]) {
            return false;
        }

        if(i == j) {
            return true;
        }

        visited[i] = true;
        for(int f : family[i]) {
            if(!visited[f]) {
                count += 1;
                if(DFS(f, j)) {
                    return true;
                }
                count -= 1;
            }
        }
        return false;
    }
}