import java.io.*;
import java.util.*;

public class Main {

    static int K, L, lastIndex;
    static HashMap<String, String> queue = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer str = new StringTokenizer(br.readLine());

        K = Integer.parseInt(str.nextToken());
        L = Integer.parseInt(str.nextToken());
        lastIndex = 0;

        for(int i = 1; i <= L; i++) {
            String hakbun = br.readLine();
            lastIndex = i;

            if(queue.containsKey(hakbun)) {
                String key = queue.get(hakbun);
                queue.remove(key);
                queue.put(String.valueOf(i), hakbun);
                queue.replace(hakbun, String.valueOf(i));
                continue;
            }

            queue.put(String.valueOf(i), hakbun);
            queue.put(hakbun, String.valueOf(i));
        }

        int count = 0;

        for(int i = 1; i <= lastIndex; i++) {
            if(count >= K) {
                break;
            }

            if(queue.containsKey(String.valueOf(i))) {
                sb.append(queue.get(String.valueOf(i))).append("\n");
                count++;
            }
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

}