import java.io.*;
import java.util.*;

public class Main {

    static final String THE_WAR = "SYJKGW\n";
    static int N, M;
    static String num;
    static HashMap<String, Integer> war;
    static List<String> result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str;

        N = Integer.parseInt(br.readLine());
        outer : for(int i = 0; i < N; i++) {
            war = new HashMap<>();
            str = new StringTokenizer(br.readLine());
            M = Integer.parseInt(str.nextToken());

            for(int j = 0; j < M; j++) {
                num = str.nextToken();
                war.put(num, war.getOrDefault(num, 0)+1);
            }

            int mod = M / 2;
            for(Map.Entry<String, Integer> entry : war.entrySet()) {
                if(entry.getValue() > mod) {
                    bw.write(entry.getKey() + "\n");
                    continue outer;
                }
            }
            bw.write(THE_WAR);

        }
        bw.flush();
        br.close();
        bw.close();
    }
}