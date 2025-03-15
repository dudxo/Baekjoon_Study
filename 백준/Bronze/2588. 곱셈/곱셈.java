import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static String M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        M = br.readLine();

        bw.write(String.valueOf(N*(Integer.parseInt(String.valueOf(M.charAt(2))))) + "\n");
        bw.write(String.valueOf(N*(Integer.parseInt(String.valueOf(M.charAt(1))))) + "\n");
        bw.write(String.valueOf(N*(Integer.parseInt(String.valueOf(M.charAt(0))))) + "\n");
        bw.write(String.valueOf(N*(Integer.parseInt(M))));

        bw.flush();
        br.close();
        bw.close();
    }


}