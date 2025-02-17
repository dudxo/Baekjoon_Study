import java.io.*;
import java.util.*;

public class Main {

    static int N, l1, l2;
    static int[] liquid;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer str;

        N = Integer.parseInt(br.readLine());
        liquid = new int[N];
        str = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            liquid[i] = Integer.parseInt(str.nextToken());
        }

        solve();
        sb.append(l1).append(" ").append(l2);

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    private static void solve() {
        int st = 0;
        int ed = N-1;
        int answer = Integer.MAX_VALUE;

        while(st < ed) {
            int mix = Math.abs(liquid[ed] + liquid[st]);
            if(Math.abs(answer) >= mix) {
                answer = liquid[ed] + liquid[st];
                l1 = liquid[st];
                l2 = liquid[ed];
            }
            if(liquid[ed] + liquid[st] > 0) {
                ed -= 1;
            } else {
                st += 1;
            }
        }
    }

}