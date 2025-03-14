import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static long[] arr, galaxy;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());

        arr = new long[N+1];
        Arrays.fill(arr, -1);

        galaxy = new long[N+1];
        for(int i = 1; i <= N; i++) {
            galaxy[i] = Long.parseLong(br.readLine());
        }

        long u = 0, v = 0;
        for(int i = 0; i < M; i++) {
            str = new StringTokenizer(br.readLine());

            u = Long.parseLong(str.nextToken());
            v = Long.parseLong(str.nextToken());

            union(u, v);
            bw.write(String.valueOf(galaxy[(int)find(u)]) + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    private static long find(long u) {
        if(arr[(int)u] < 0) return u;

        return arr[(int)u] = find(arr[(int)u]);
    }

    private static void union(long u, long v) {
        u = find(u);
        v = find(v);

        if(u == v) return;

        if(v < u) {
            long tmp = u;
            u = v;
            v = tmp;
        }

        if(arr[(int)u] == arr[(int)v]) arr[(int)u]--;

        arr[(int)v] = u;
        galaxy[(int)u] += galaxy[(int)v];
    }

}