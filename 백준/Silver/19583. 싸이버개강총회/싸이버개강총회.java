import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    static String cmd;
    static int s, st, ed, sEd;
    static HashMap<String, Integer> bf = new HashMap<>();
    static HashMap<String, Integer> af = new HashMap<>();

    public static void main(String[] args) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer str = new StringTokenizer(br.readLine());

        cmd = str.nextToken();
        st = (Integer.parseInt(cmd.substring(0, 2)) * 60) + (Integer.parseInt(cmd.substring(3)));
        cmd = str.nextToken();
        ed = (Integer.parseInt(cmd.substring(0, 2)) * 60) + (Integer.parseInt(cmd.substring(3)));
        cmd = str.nextToken();
        sEd = (Integer.parseInt(cmd.substring(0, 2)) * 60) + (Integer.parseInt(cmd.substring(3)));

        String line = "";
        int result = 0;
        while((line = br.readLine()) != null && !line.isEmpty()) {
            str = new StringTokenizer(line);
            cmd = str.nextToken();
            int time = (Integer.parseInt(cmd.substring(0, 2)) * 60) + (Integer.parseInt(cmd.substring(3)));
            String name = str.nextToken();

            if(time <= st) {
                bf.put(name, bf.getOrDefault(name, 0) + 1);
                continue;
            }

            if(ed <= time && time <= sEd) {
                af.put(name, af.getOrDefault(name, 0) + 1);
            }
        }

        Set<String> bfKeys = bf.keySet();
        for(String bfKey : bfKeys) {
            if(af.containsKey(bfKey)) {
                result += 1;
            }
        }


        sb.append(result);

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

}