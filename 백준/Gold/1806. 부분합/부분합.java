import java.io.*;
import java.util.*;

public class Main {

    static final int INF = Integer.MAX_VALUE;
    static int N, S, result;
    static int[] sum, arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        S = Integer.parseInt(str.nextToken());

        sum = new int[N+1];
        arr = new int[N+1];
        result = INF;

        str = new StringTokenizer(br.readLine());
        int st = INF;
        for(int i = 1; i <= N; i++) {
            int num = Integer.parseInt(str.nextToken());

            sum[i] = sum[i-1] + num;
            arr[i] = num;
            if(sum[i] >= S) {
                st = Math.min(st, i);
            }
        }

        if(st != INF) {
           sol(st);
        }

        sb.append(result == INF ? "0" : result);

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    private static void sol(int s) {
        int st = 0;
        int ed = s;

        while(ed <= N && st <= N) {
            if(sum[ed]-sum[st] >= S) {
                result = Math.min(result, ed - st);
                st++;
            } else {
                ed++;
            }
        }
    }

}