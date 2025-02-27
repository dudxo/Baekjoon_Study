import java.io.*;
import java.util.*;

public class Main {

    static final int INF = Integer.MAX_VALUE;
    static int N;
    static int[] arr;
    static int[] result;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer str;

        result = new int[2];

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        str = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(str.nextToken());
        }

        Arrays.sort(arr);

        sol();
        sb.append(result[0]).append(" ").append(result[1]);


        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    private static void sol() {
        int st = 0;
        int ed = N-1;

        int tmp = INF;

        while(st < ed) {
            if(Math.abs(arr[ed] + arr[st]) <= tmp) {
                tmp = Math.abs(arr[ed] + arr[st]);
                result[0] = arr[st];
                result[1] = arr[ed];
            }

            if(arr[ed] + arr[st] > 0) {
                ed--;
            }
            else {
                st++;
            }
        }
    }

}