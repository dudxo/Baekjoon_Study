import java.io.*;
import java.util.*;

public class Main {

    static double N;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer str;

        N = Double.parseDouble(br.readLine());
        sb.append((N % 5 == 0 || N % 5 == 2) ? "CY" : "SK");

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }



}