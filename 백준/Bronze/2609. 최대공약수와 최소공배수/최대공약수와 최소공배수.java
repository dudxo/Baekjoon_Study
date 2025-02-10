import java.io.*;
import java.util.*;

public class Main {

    static int x, y;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer str = new StringTokenizer(br.readLine());

        x = Integer.parseInt(str.nextToken());
        y = Integer.parseInt(str.nextToken());

        sb.append(gcd(x, y)).append("\n");
        sb.append((x * y) / gcd(x, y));



        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    private static int gcd(int x, int y) {
        if(y == 0) {
            return x;
        }

        return gcd(y, x % y);
    }

}