import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Integer>[] A;
    private static boolean[] visited;
    private static int[] jibhap;
    private static boolean answer;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int K = sc.nextInt();
        for(int i = 0; i < K; i++) {
            answer = true;

            int V = sc.nextInt();
            int E = sc.nextInt();
            A = new ArrayList[V+1];
            visited = new boolean[V+1];
            jibhap = new int[V+1];
            for(int j = 1; j <= V; j++) {
                A[j] = new ArrayList<Integer>();
            }
            for(int j = 1; j <=E; j++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                A[u].add(v);
                A[v].add(u);
            }
            for(int j = 1; j <= V; j++) {
                if(answer) {
                    DFS(j);
                } else {
                    break;
                }
            }
            if(answer) {
                bw.write("YES\n");
            } else {
                bw.write("NO\n");
            }

        }
        bw.flush();
        bw.close();
    }

    private static void DFS(int i) {
        if(visited[i]) {
            return;
        }
        visited[i] = true;

        for(int j : A[i]) {
            if(!visited[j]) {
                jibhap[j] = (jibhap[i] == jibhap[j]) ? 1 : 0;
                DFS(j);
            } else if (jibhap[i] == jibhap[j]) {
                answer = false;
            }
        }
    }
}
