import java.io.*;
import java.util.*;

public class Main {

    static int N, result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        StringTokenizer str = new StringTokenizer(br.readLine());

        while(str.hasMoreTokens()) {
            int num = Integer.parseInt(str.nextToken());

            boolean flag = true;

            if(num <= 1) {
                continue;
            }

            for(int i = 2; i < num; i++) {
                if(num % i == 0) {
                    flag = false;
                    break;
                }
            }

            if(flag) {
                result += 1;
            }
        }

        sb.append(result);

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }


}