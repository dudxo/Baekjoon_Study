import java.io.*;
import java.util.*;

public class Main {

    static int sum;
    static int[] arr, tmp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer str;

        arr = new int[9];
        tmp = new int[7];

        for(int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        Arrays.sort(arr);

        outer : for(int i = 0; i < 9; i++) {
            for(int j = i+1; j < 9; j++) {
                if(sum - arr[i] - arr[j] == 100) {
                    arr[i] = 0;
                    arr[j] = 0;
                    break outer;
                }
            }
        }

        for(int i = 0; i < 9; i++) {
            if(arr[i] != 0) {
                sb.append(arr[i]).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }


}