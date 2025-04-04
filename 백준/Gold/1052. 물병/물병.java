import java.io.*;
import java.util.*;

public class Main {

    static int N, K, result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str;

        str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        K = Integer.parseInt(str.nextToken());

        result = 0;
        while(true) {
            if(Integer.bitCount(N) <= K) {
                break;
            }

            N++;
            result++;
        }

        bw.write(String.valueOf(result));
        bw.flush();
    }

}