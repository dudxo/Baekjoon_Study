import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int N, count;
    static char[][] apt;
    static boolean[][] visited;
    static List<Integer> answer = new ArrayList<>();

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.nextLine();
        apt = new char[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            String homes = sc.nextLine();
            for(int j = 0; j < N; j++) {
                apt[i][j] = homes.charAt(j);
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                   int count = BFS(i,j);
                   if(count > 0) {
                       answer.add(count);
                   }
                }
            }
        }


        Collections.sort(answer);
        System.out.println(answer.size());
        for(int i : answer) {
            System.out.println(i);
        }
    }

    private static int BFS(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {i, j});
        visited[i][j] = true;

        if(apt[i][j] == '0') {
            return 0;
        }
        count = 1;

        while(!q.isEmpty()) {
            int[] now = q.poll();

            for(int k =0; k < 4; k++) {
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];
                if(x >= 0 && y >= 0 && x < N && y < N) {
                    if(apt[x][y] == '1' && !visited[x][y]) {
                        count += 1;
                        visited[x][y] = true;
                        q.add(new int[] {x, y});
                    }
                }
            }
        }
        return count;
    }
}


