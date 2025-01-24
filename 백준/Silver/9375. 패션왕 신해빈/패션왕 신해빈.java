import java.io.*;
import java.util.*;

public class Main {

    static int T, N, result;
    static HashMap<String, Integer> clothes;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            clothes = new HashMap<>();
            result = 0;
            N = Integer.parseInt(br.readLine());
            for(int i = 0; i < N; i++) {
                int count = 1;
                StringTokenizer str = new StringTokenizer(br.readLine());
                String name = str.nextToken();
                String type = str.nextToken();
                if(clothes.containsKey(type)) {
                    count = clothes.get(type) + 1;
                    clothes.replace(type, count);
                    continue;
                }

                clothes.put(type, count);
            }

            Set<String> keys = clothes.keySet();

            if(keys.size() == 1) {
                for(String key : keys) {
                    sb.append(clothes.get(key)).append("\n");
                }
            } else {
                int num = 1;

                for(String key : keys) {
                    num *= clothes.get(key) + 1;
                }

                sb.append(num-1).append("\n");
            }
        }


        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

}