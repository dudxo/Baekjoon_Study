import java.io.*;
import java.util.*;

public class Main {

    static int k;
    static int LOTTO = 6;
    static int[] s, arr;
    static boolean[] isUsed;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        do {
            StringTokenizer str = new StringTokenizer(br.readLine());
            k = Integer.parseInt(str.nextToken());
            if(k == 0) {
                break;
            }

            s = new int[k];
            arr = new int[LOTTO];
            isUsed = new boolean[k];

            for(int i = 0; i < k; i++) {
                s[i] = Integer.parseInt(str.nextToken());
            }

            Arrays.sort(s);

            backTracking(0, sb);
            sb.append("\n");
        }while(true);

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    private static void backTracking(int i, StringBuilder sb) {
        if(i == LOTTO) {
            for(int j : arr) {
                sb.append(j).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int j = 0; j < k; j++) {
            if(!isUsed[j]) {
                if(i != 0 && s[j] <= arr[i-1]) {
                    continue;
                }
                arr[i] = s[j];
                isUsed[j] = true;
                backTracking(i+1, sb);
                isUsed[j] = false;
            }
        }
    }

}