import java.io.*;
import java.util.*;

public class Main {

    static String S, T;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer str;

        S = br.readLine();
        T = br.readLine();

        sb.append(sol());

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    private static int sol() {
        while(T.length() != S.length()) {
            switch(T.charAt(T.length()-1)) {
                case 'A':
                    T = T.substring(0, T.length()-1);
                    break;
                case 'B':
                    T = T.substring(0, T.length()-1);
                    T = new StringBuilder(T).reverse().toString();
            }
        }
        return S.equals(T) ? 1 : 0;
    }
}