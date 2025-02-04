import java.io.*;
import java.util.*;

public class Main {

    static long N, S, M, L, XL, XXL, XXL2, T, P;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Long.parseLong(br.readLine());
        StringTokenizer str = new StringTokenizer(br.readLine());
        S = Long.parseLong(str.nextToken());
        M = Long.parseLong(str.nextToken());
        L = Long.parseLong(str.nextToken());
        XL = Long.parseLong(str.nextToken());
        XXL = Long.parseLong(str.nextToken());
        XXL2 = Long.parseLong(str.nextToken());

        str = new StringTokenizer(br.readLine());
        T = Long.parseLong(str.nextToken());
        P = Long.parseLong(str.nextToken());

        long clothesTotal = clothes(S) + clothes(M) + clothes(L) + clothes(XL) + clothes(XXL) + clothes(XXL2);
        sb.append(clothesTotal).append("\n");

        sb.append(N / P).append(" ").append(N % P);

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    private static long clothes(long size) {
        if(size == 0) {
            return 0;
        }

        if(size / T == 0) {
            return 1;
        }

        if(size % T != 0) {
            return size / T + 1;
        }

        return size / T;
    }

}