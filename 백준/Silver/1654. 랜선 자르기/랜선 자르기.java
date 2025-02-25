import java.io.*;
import java.util.*;

public class Main {

    static int N, K, result;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        K = Integer.parseInt(str.nextToken());
        arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        int min = arr[N-1];



        sb.append(binary_search(min));


        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    private static long binary_search(int min) {
        long st = 1;
        long ed = min;

        while(st <= ed) {
            long mid = (st+ed) / 2;
            if(sol(mid)) {
                ed = mid-1;
            } else {
                st = mid+1;
            }
        }
        return ed;
    }

    private static boolean sol(long mid) {
        int total = 0;
        for(int i = 0; i < N; i++) {
            total += arr[i] / mid;
        }

        return total < K;
    }

}