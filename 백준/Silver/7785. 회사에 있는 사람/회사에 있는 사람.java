import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static HashMap<String, String> humans = new HashMap<>();
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        while(N-- > 0) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            humans.put(str.nextToken(), str.nextToken());
        }

        Set<String> keys = humans.keySet();
        for(String key : keys) {
            if(humans.get(key).equals("enter")) {
                list.add(key);
            }
        }

        Collections.sort(list, Collections.reverseOrder());

        for(String name : list) {
            sb.append(name).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

}