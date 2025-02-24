import java.io.*;
import java.util.*;

public class Main {

    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        int tmp = N;
        int result = Integer.MAX_VALUE;

        while(true) {
            char[] arr = String.valueOf(tmp).toCharArray();

            int num = tmp;
            for(int i = 0; i < arr.length; i++) {
                num += arr[i] - 48;
            }
            if(N == num) {
                result = Math.min(result, tmp);
            }

            if(tmp == 0) {
                if(result == Integer.MAX_VALUE) {
                   result = 0;
                }
                break;
            }
            tmp--;
        }

        sb.append(result);
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }


}