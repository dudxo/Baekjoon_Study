import java.io.*;
import java.util.*;

public class Main {

    static final int INF = Integer.MIN_VALUE;
    static int N, result;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer str = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(str.nextToken());
        }

        if(N == 2) {
            result = 0;
        } else {
            sol();
        }

        sb.append(result == INF ? "-1" : result);

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    private static void sol() {
        int st = 0;
        int ed = N-1;

        while(st < ed) {
            result = Math.max(result, ((ed-st-1) * Math.min(arr[st], arr[ed])));
            if(arr[st] <= arr[ed]) {
                st++;
            } else {
                ed--;
            }
        }
    }

}