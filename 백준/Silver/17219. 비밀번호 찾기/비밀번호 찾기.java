import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static HashMap<String, String> password = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer str = new StringTokenizer(br.readLine());

        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());

        for(int i = 0; i < N; i++) {
            str = new StringTokenizer(br.readLine());
            password.put(str.nextToken(), str.nextToken());
        }

        for(int i = 0; i < M; i++) {
            sb.append(password.get(br.readLine())).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

}