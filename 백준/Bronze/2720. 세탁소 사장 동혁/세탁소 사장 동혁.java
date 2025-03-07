import java.io.*;
import java.util.*;

public class Main {

    static final int Q = 25;
    static final int D = 10;
    static final int N = 5;
    static final int P = 1;
    static final int COIN = 4;
    static int[] result;
    static int T;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            result = new int[COIN];
            int money = Integer.parseInt(br.readLine());

            result[0] = money / Q;
            money %= Q;
            result[1] = money / D;
            money %= D;
            result[2] = money / N;
            money %= N;
            result[3] = money / P;

            for(int i = 0; i < COIN; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}