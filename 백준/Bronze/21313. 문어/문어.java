import java.io.*;
import java.util.*;

public class Main {

    static int N, white, blue;
    static int[][] map;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer str;

        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            if(i == N-1 && (N%2) != 0) {
                sb.append("3 ");
                continue;
            }

            if(i % 2 == 0) {
                sb.append("1 ");
                continue;
            }

            sb.append("2 ");
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

}