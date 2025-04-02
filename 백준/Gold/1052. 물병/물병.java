import java.io.*;
import java.util.*;

public class Main {

    static int N, K, result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str;

        result = -1;
        str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        K = Integer.parseInt(str.nextToken());

        sol();
        bw.write(String.valueOf(result));

        bw.flush();
    }

    private static void sol() {
        if(N <= K) {
            result = 0;
            return;
        }

        int buy = 0;

        while(true) {
            int total = N + buy;
            int count = 0;
            while(total > 0) {
                if(total % 2 != 0) {
                    count++;
                }
                total /= 2;
            }

            if(count <= K) break;

            buy++;
        }


        result = buy;

    }

}