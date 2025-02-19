import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int c, s;
    static int[][] graph;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        c = sc.nextInt();
        graph = new int[c+1][c+1];
        s = sc.nextInt();

        for(int i = 0; i < s; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        BFS();
    }

    private static void BFS(){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[c+1];
        List<Integer> virus = new LinkedList<>();

        queue.add(1);

        while(!queue.isEmpty()) {
            int index = queue.poll();

            if(!visited[index]) {
                virus.add(index);
            }

            visited[index] = true;

            for(int i = 1; i <= c; i++) {
                if(graph[index][i] == 1 && !visited[i]) {
                    queue.add(i);
                }
            }
        }
        System.out.println(virus.size() - 1);
    }




}


