import java.io.*;
import java.util.*;


public class Main {

    static int N, K, result;
    static int[] arr, num;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str;

        str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        K = Integer.parseInt(str.nextToken());

        num = new int[100001];

        arr = new int[N];
        str = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(str.nextToken());
        }

        sol();

        bw.write(String.valueOf(result));
        bw.flush();
    }

    private static void sol() {
        int st = 0;
        int ed = 0;

        int i = 0;
        while(ed < N) {
            while(ed < N && num[arr[ed]] + 1 <= K){
                num[arr[ed++]]++;
            }

            result = Math.max(result, ed - st);
            num[arr[st]]--;
            st++;
        }
    }
}