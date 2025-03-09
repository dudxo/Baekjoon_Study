import java.io.*;
import java.util.*;

public class Main {

    static int N, total, min, max;
    static int[] arr;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer str = new StringTokenizer(br.readLine());
        for(int i = 0;  i< N; i++) {
            arr[i] = Integer.parseInt(str.nextToken());
        }

        total = Integer.parseInt(br.readLine());

        bw.write(String.valueOf(sol()));

        bw.flush();
        br.close();
        bw.close();
    }

    private static long sol() {
        long st = 0;
        long ed = Arrays.stream(arr).max().getAsInt();

        while(st < ed) {
            long mid = (st+ed+1) / 2;
            if(solve(mid)) {
                st = mid;
            } else {
                ed = mid - 1;
            }
        }

        return st;
    }

    private static boolean solve(long mid) {
        long sum = 0;
        for(int i = 0; i < N; i++) {
            long num = arr[i];
            if(mid <= num) {
                num = mid;
            }
            sum += num;
        }

        return sum <= total;
    }

}
