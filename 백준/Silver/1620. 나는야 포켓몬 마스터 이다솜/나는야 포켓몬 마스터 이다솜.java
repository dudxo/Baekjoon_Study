import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static HashMap<String, String> poketMons1 = new HashMap<>();
    static HashMap<String, String> poketMons2 = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());

        for(int i = 1; i <= N; i++) {
            String name = br.readLine();
            poketMons1.put(String.valueOf(i), name);
            poketMons2.put(name, String.valueOf(i));
        }

        for(int i = 0; i < M; i++) {
            String prb = br.readLine();

            if(Character.isDigit(prb.charAt(0))) {
                sb.append(poketMons1.get(prb)).append("\n");
                continue;
            }

            sb.append(poketMons2.get(prb)).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

}