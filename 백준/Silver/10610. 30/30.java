import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    static int[] input, arr;
    static final int THIRTY = 30;
    static int total, result;
    static boolean[] isUsed;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();
        input = new int[s.length()];
        arr = new int[10];
        total = 0;
        for(int i = 0; i < s.length(); i++) {
            int k = Integer.parseInt(String.valueOf(s.charAt(i)));
            arr[k] += 1;
            total += k;
        }

        if(!s.contains("0") || total % 3 != 0) {
            result = -1;
            sb.append(result);
        } else {
            for(int i = 9; i >= 0; i--) {
                while(arr[i] > 0) {
                    sb.append(i);
                    arr[i]--;
                }
            }
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}