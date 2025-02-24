import java.io.*;
import java.util.*;

public class Main {

    static int N, M, K;
    static int[] arr, cost, arr2;
    static ArrayList<ArrayList<Integer>> graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());
        K = Integer.parseInt(str.nextToken());

        arr = new int[N+1];
        cost = new int[N+1];
        arr2 = new int[N+1];
        graph = new ArrayList<>();

        str = new StringTokenizer(br.readLine());

        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 1; i <= N; i++) {
            cost[i] = Integer.parseInt(str.nextToken());
        }

        Arrays.fill(arr, -1);

        for(int i = 0; i < M; i++) {
            str = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(str.nextToken());
            int v = Integer.parseInt(str.nextToken());

            union(u, v);
        }

        for(int i = 1; i <= N; i++) {
            graph.get(find(i)).add(i);
        }

        int total = 0;
        for(int i = 1; i <= N; i++) {
            ArrayList<Integer> list = graph.get(i);
            int min = Integer.MAX_VALUE;
            for(int index : list) {
                min = Math.min(min, cost[index]);
            }
            if(min == Integer.MAX_VALUE) {
                continue;
            }
            total += min;
        }

        if(total <= K) {
            sb.append(total);
        } else {
            sb.append("Oh no");
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a == b) {
            return;
        }

        if(arr[b] < arr[a]) {
            int tmp = a;
            a = b;
            b = tmp;
        }

        if(arr[a] == arr[b]) {
            arr[a]--;
        }

        arr[b] = a;
    }

    private static int find(int a) {
        if(arr[a] < 0) {
            return a;
        }

        return arr[a] = find(arr[a]);
    }


}