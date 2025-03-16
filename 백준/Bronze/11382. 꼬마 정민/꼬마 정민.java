import java.io.*;
import java.util.*;

public class Main {

    static long num;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer str = new StringTokenizer(br.readLine());
        while(str.hasMoreTokens()) {
            num += Long.parseLong(str.nextToken());
        }

        bw.write(String.valueOf(num));
        bw.flush();
        br.close();
        bw.close();
    }
}