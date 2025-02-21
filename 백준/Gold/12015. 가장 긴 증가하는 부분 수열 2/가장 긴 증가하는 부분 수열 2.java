import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new int[N];

        StringTokenizer str = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(str.nextToken());
        }

        dp[0] = arr[0];

        int index = 1;
        for(int i = 1; i < N; i++) {
            if(dp[index-1] < arr[i]) {
                dp[index++] = arr[i];
                continue;
            }

            binary_search(arr[i], index);
        }

        int result = 0;
        for(int i : dp) {
            if(i != 0) {
                result += 1;
            }
        }

        sb.append(result);

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    private static void binary_search(int i, int index) {
        int st = 0;
        int ed = index;

        while(st <= ed) {
            int mid = (st+ed) / 2;

            if(dp[mid] < i) {
                st = mid+1;
            } else {
                ed = mid-1;
            }
        }

        dp[st] = i;
    }

}