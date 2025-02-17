import java.io.*;
import java.util.*;

public class Main {

    static int N, K;
    static long count;
    static int[] grape;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer str;

        str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        K = Integer.parseInt(str.nextToken());

        grape = new int[N];

        str = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            grape[i] = Integer.parseInt(str.nextToken());
        }

        Arrays.sort(grape);

        count = 0;
        count += grape[N-1];
        K -= 1;

        int st = 0;
        int ed = N - 2;

        while(K > 1) {
            count += grape[ed--] - grape[st++];
            K -= 2;
        }

        sb.append(count);

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}