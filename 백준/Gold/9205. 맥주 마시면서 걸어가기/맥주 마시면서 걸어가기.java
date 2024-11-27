import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int t, n, beer;
    static int[] home, festival;
    static boolean[] visited, result;
    static List<int[]> shops;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        beer = 1000;
        t = sc.nextInt();
        result = new boolean[t];
        sc.nextLine();
        for(int i = 0; i < t; i++) {
            shops = new ArrayList<>();
            n = sc.nextInt();
            int hx = sc.nextInt();
            int hy = sc.nextInt();
            home = new int[] {hx, hy};
            for(int j = 0; j < n; j++) {
                int sx = sc.nextInt();
                int sy = sc.nextInt();
                shops.add(new int[] {sx, sy});
            }

            visited = new boolean[shops.size()];

            int fx = sc.nextInt();
            int fy = sc.nextInt();
            festival = new int[] {fx, fy};

            DFS(home, i);

        }
        for(boolean b : result) {
            if(b) {
                System.out.println("happy");
            } else {
                System.out.println("sad");
            }
        }
    }

    private static void DFS(int[] start, int t) {
        if(Math.abs(start[0]-festival[0]) + Math.abs(start[1]-festival[1]) <= beer) {
            result[t] = true;
            return;
        }

        for(int i = 0; i < shops.size(); i++) {
            int[] shop = shops.get(i);

            if(!visited[i]) {
                if(Math.abs(start[0]-shop[0]) + Math.abs(start[1]-shop[1]) <= 1000) {
                    visited[i] = true;
                    DFS(shop, t);
                }
            }
        }
    }

}