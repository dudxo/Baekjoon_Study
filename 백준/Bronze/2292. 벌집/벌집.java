import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static long line, result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        line = 1;
        result = 1;

        if(N == 1) {
            sb.append("1");
        } else {
            while(result < N) {
                result += 6 * line;
                line++;
            }
            sb.append(line);
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }


}