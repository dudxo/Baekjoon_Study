import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static long result;
    static char[] cArr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        cArr = br.readLine().toCharArray();

        for(int i = 0; i < N; i++) {
            result += ((cArr[i] - 'a')+1) * Math.pow(31, i);
        }
        sb.append(result);

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }


}