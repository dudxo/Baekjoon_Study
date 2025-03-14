import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] arr, dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        arr = new int[10000001];
        Arrays.fill(arr, -1);
        dist = new int[10000001];
        Arrays.fill(dist, 1);


        N = Integer.parseInt(br.readLine());
        StringTokenizer str;

        String s = "";
        int u = 0, v = 0;
        for(int i = 0; i < N; i++) {
            str = new StringTokenizer(br.readLine());

            s = str.nextToken();
            if(s.equals("I")) {
                u = Integer.parseInt(str.nextToken());
                v = Integer.parseInt(str.nextToken());

                union(u, v);
            } else {
                u = Integer.parseInt(str.nextToken());

                u = dist[find(u)];
                bw.write(String.valueOf(Math.abs(u)) + "\n");
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }

    private static int find(int u) {
        if(arr[u] < 0) return u;

        return arr[u] = find(arr[u]);
    }

    private static void union(int u, int v) {
        u = find(u);
        v = find(v);

        if(u == v) return;

        if(arr[v] < arr[u]) {
            int tmp = u;
            u = v;
            v = tmp;
        }

        if(arr[u] == arr[v]) arr[u]--;

        arr[v] = u;
        dist[u] += dist[v];
    }

}