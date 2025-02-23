import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static final int M = 1234567891;
    static long pow, result;
    static char[] cArr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        cArr = br.readLine().toCharArray();
        pow = 1;

        for(int i = 0; i < N; i++) {
            result += (cArr[i] - 96) * pow % M;
            pow = (pow * 31) % M;
        }

        sb.append(result  % M);

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }


}