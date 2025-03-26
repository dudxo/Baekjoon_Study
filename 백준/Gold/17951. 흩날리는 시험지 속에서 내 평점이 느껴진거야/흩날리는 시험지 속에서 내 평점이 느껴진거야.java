import java.io.*;
import java.util.*;

public class Main {

    static int N, M, result, min, sum;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer str;

        str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());

        arr = new int[N];
        min = Integer.MAX_VALUE;
        sum = 0;

        str = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N; i++) {
            sum += arr[i] = Integer.parseInt(str.nextToken());
            min = Math.min(min, arr[i]);
        }

        sb.append(binarySearch(min, sum));

        bw.write(sb.toString());
        bw.flush();
    }

    private static int binarySearch(int st, int ed) {
        int mid = 0;
        while(st <= ed) {
            mid = (st+ed) / 2;

            if(sol(mid)) {
                ed = mid -1;
            } else {
                st = mid + 1;
            }
        }

        return ed;
    }

    private static boolean sol(int mid) {
        int group = 0;
        int sum = 0;
        for(int i = 0; i < N; i++) {
            sum += arr[i];
            if(sum >= mid) {
                group++;
                sum = 0;
            }
        }

        return group < M;
    }

}