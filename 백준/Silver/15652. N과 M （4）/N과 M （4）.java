import java.io.*;
import java.util.*;
public class Main {

    static int N, M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str = new StringTokenizer(br.readLine());

        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());

        arr = new int[M];

        br.close();

        solve(0);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void solve(int k) {
        if(k == M) {
            for(int index : arr) {
                sb.append(index).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 1; i <= N; i++) {
            if(k >= 1 && arr[k-1] > i) {
                continue;
            }
            arr[k] = i;
            solve(k+1);
        }
    }

}