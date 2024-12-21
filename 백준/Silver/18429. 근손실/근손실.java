import java.io.*;
import java.util.*;
public class Main {

    static int N, K, count;
    static int weight = 500;
    static int GOAL = 500;
    static int[] arr, kits;
    static boolean[] isUsed;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        K = Integer.parseInt(str.nextToken());
        str = new StringTokenizer(br.readLine());

        arr = new int[N];
        kits = new int[N];
        isUsed = new boolean[N];

        for(int i = 0; i < N; i++) {
            kits[i] = Integer.parseInt(str.nextToken());
        }

        count = 0;

        solved(0);

        StringBuilder sb = new StringBuilder();
        sb.append(count);
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    private static void solved(int k) {
        if(k == N) {
            for(int index : arr) {
                weight = weight + index - K;
                if(weight < GOAL) {
                    weight = 500;
                    return;
                }
            }
            count += 1;
            weight = 500;
            return;
        }

        for(int i = 0; i < N; i++) {
            if(!isUsed[i]) {
                arr[k] = kits[i];
                isUsed[i] = true;
                solved(k+1);
                isUsed[i] = false;
            }
        }
    }

}