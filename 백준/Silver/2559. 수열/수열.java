import java.io.*;
import java.util.*;


public class Main {

    static int N, K, sum, result;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str;

        str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        K = Integer.parseInt(str.nextToken());

        arr = new int[N];
        str = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(str.nextToken());
        }

        for(int i = 0; i < K; i++) {
            sum += arr[i];
        }

        sol();

        bw.write(String.valueOf(result));
        bw.flush();
    }

    private static void sol() {
        int st = 0;
        int ed = K;

        result = sum;

        while(ed != N) {
            sum -= arr[st++];
            sum += arr[ed++];

            result = Math.max(result, sum);
        }
    }

}