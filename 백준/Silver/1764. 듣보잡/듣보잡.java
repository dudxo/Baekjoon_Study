import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static HashMap<String, String> names = new HashMap<>();
    static List<String> result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str;

        str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());
        result = new ArrayList<>();

        String name = "";
        for(int i = 0; i < N; i++) {
            name = br.readLine();
            names.put(name, name);
        }

        for(int i = 0; i < M; i++) {
            name = br.readLine();
            if(names.get(name) != null) result.add(name);
        }

        Collections.sort(result);
        bw.write(result.size() + "\n");
        for(String s : result) {
            bw.write(s + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }


}