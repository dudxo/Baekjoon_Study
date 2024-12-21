import java.io.*;
import java.util.*;
public class Main {

    static int N;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        sb = new StringBuilder();
        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());

        star(N);
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    private static void star(int n) {
        for(int i = 1; i <= n; i++) {
            for(int j = n-i; j > 0; j--) {
                sb.append(" ");
            }
            for(int j = 2*i-1; j > 0; j--) {
                sb.append("*");
            }
            sb.append("\n");
        }
    }

}