import java.io.*;
import java.util.*;

public class Main {

    static int A, B, V;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer str = new StringTokenizer(br.readLine());
        A = Integer.parseInt(str.nextToken());
        B = Integer.parseInt(str.nextToken());
        V = Integer.parseInt(str.nextToken());

        int day = (V-B) / (A-B);
        if((V-B) % (A-B) != 0) day++;

        sb.append(day);
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }


}