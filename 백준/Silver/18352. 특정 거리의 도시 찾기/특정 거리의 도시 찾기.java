import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    private static ArrayList<Integer> answer;
    private static ArrayList<Integer>[] A;
    private static int[] visited;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int city = sc.nextInt();
        int road = sc.nextInt();
        int D = sc.nextInt();
        int S = sc.nextInt();

        A = new ArrayList[city+1];
        answer = new ArrayList<>();

        for(int i = 1; i <= city; i++) {
            A[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i < road; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            A[s].add(e);
        }


        visited = new int[city+1];
        for(int i = 1; i <= city; i++) {
            visited[i] = -1;
        }
        BFS(S);
        for(int i = 0; i <= city; i++) {
            if(visited[i] == D){
                answer.add(i);
            }
        }
        if(answer.isEmpty()) {
            System.out.println("-1");
        }
        Collections.sort(answer);
        for(int temp : answer) {
            System.out.println(temp);
        }

    }

    private static void BFS(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node]++;
        while(!queue.isEmpty()) {
            int now_node = queue.poll();
            for (int i : A[now_node]) {
                if(visited[i] == -1) {
                    visited[i] = visited[now_node] + 1;
                    queue.add(i);
                }
            }
        }
    }

}
