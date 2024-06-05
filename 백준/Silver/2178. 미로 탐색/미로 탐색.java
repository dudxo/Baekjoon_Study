import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int N, M;
    static int[][] arr;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());

        arr = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];
        //미로 생성
        for(int i = 1; i < N+1; i++){
            String st = br.readLine();
            for(int j = 1; j < M+1; j++){
                arr[i][j] = Integer.parseInt(st.substring(j-1, j));
            }
        }
        br.close();

        BFS(1,1);
        System.out.println(arr[N][M]);
    }

    public static void BFS(int i, int j){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {i, j});
        visited[i][j] = true;
        while(!q.isEmpty()){
            int now[] = q.poll();
            for(int k = 0; k < 4; k++){
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];
                if(x >= 1 && y >= 1 && x < N+1 && y < M+1){
                    if(arr[x][y] != 0 && !visited[x][y]){
                        visited[x][y] = true;
                        arr[x][y] = arr[now[0]][now[1]] + 1;
                        q.offer(new int[] {x,y});
                    }
                }
            }
        }
    }
}
