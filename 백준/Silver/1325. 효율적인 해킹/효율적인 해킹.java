import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static ArrayList<Integer>[] A;
    private static int[] answer;
    private static boolean[] visited;
    private static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        A = new ArrayList[N+1];
        answer = new int[N+1];

        for(int i = 1; i <= N; i++) {
            A[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int E = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());
            A[S].add(E);
        }

        for(int i = 1; i <= N; i++) {
            count = 0;
            visited = new boolean[N+1];
            DFS(i);
            answer[i] = count;
        }

        int max = Arrays.stream(answer).max().getAsInt();

        for(int i = 1; i <= N; i++) {
            if(max == answer[i]) {
                bw.write(i + " ");
            }
        }

        bw.flush();
        bw.close();

    }

    private static void DFS(int S) {
        if(visited[S]) {
            return;
        }
        visited[S] = true;
        count++;
        for(int i : A[S]) {
            if(!visited[i]) {
                DFS(i);
            }
        }

    }
}