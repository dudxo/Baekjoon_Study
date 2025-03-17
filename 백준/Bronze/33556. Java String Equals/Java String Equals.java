import java.io.*;
import java.util.*;

public class Main {

    static String s1, s2;
    static final String NPE = "NullPointerException";
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        s1 = br.readLine();
        s2 = br.readLine();

        if(s1.equals("null")) s1 = null;
        if(s2.equals("null")) s2 = null;

        boolean result = false;
        try {
            result = s1.equals(s2);
            bw.write(String.valueOf(result) + "\n");
        } catch (NullPointerException ex) {
            bw.write(NPE + "\n");
        }
        try {
            result = s1.equalsIgnoreCase(s2);
            bw.write(String.valueOf(result));
        } catch (NullPointerException ex) {
            bw.write(NPE);
        }

        bw.flush();
        br.close();
        bw.close();
    }
}