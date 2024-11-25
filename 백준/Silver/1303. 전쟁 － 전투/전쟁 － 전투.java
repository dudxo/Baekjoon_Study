import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    static int N, M, count, white, blue;
    static char[][] war;
    static boolean[][] visited;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();

        war = new char[M][N];
        visited = new boolean[M][N];

        for(int i = 0; i < M; i++) {
            String team = sc.nextLine();
            for(int j = 0; j < N; j++) {
                war[i][j] = team.charAt(j);
            }
        }


        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    if(war[i][j] == 'W') {
                        int num = BFS(i, j, 'W');
                        white += num * num;
                    }
                    if(war[i][j] == 'B') {
                        int num = BFS(i, j, 'B');
                        blue += num * num;
                    }
                }
            }
        }

        System.out.println(white + " " + blue);
    }

    private static int BFS(int i, int j, char color) {
        Queue<int[]> q = new LinkedList<>();
        count = 1;

        q.add(new int[] {i, j});
        visited[i][j] = true;

        while(!q.isEmpty()) {
            int now[] = q.poll();
            for(int k = 0; k < 4; k++) {
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];
                if(x >= 0 && y >= 0 && x < M && y < N) {
                    if(war[x][y] == color && !visited[x][y]) {
                        visited[x][y] = true;
                        count++;
                        q.add(new int[] {x,y});
                    }
                }
            }
        }
        return count;
    }

}


