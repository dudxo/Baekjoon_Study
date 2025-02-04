import java.io.*;
import java.util.*;

public class Main {

    static int a, b, c;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        while(true) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            a = Integer.parseInt(str.nextToken());
            b = Integer.parseInt(str.nextToken());
            c = Integer.parseInt(str.nextToken());

            if(a == 0 && b == 0 && c == 0 ) {
                break;
            }

            int max = Math.max(a, Math.max(b, c));

            if(max == a) {
                validateTriangle(a, b, c, sb);
            } else if(max == b) {
                validateTriangle(b, a, c, sb);
            } else if(max == c) {
                validateTriangle(c, a, b, sb);
            } else {
                sb.append("wrong\n");
            }


        }


        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    private static void validateTriangle(int max, int h, int w, StringBuilder sb) {
        if(Math.pow(max, 2) == Math.pow(h, 2) + Math.pow(w, 2)) {
            sb.append("right\n");
        } else {
            sb.append("wrong\n");
        }
    }

}