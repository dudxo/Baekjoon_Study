import java.io.*;
import java.util.*;

public class Main {

    static List<Long> list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer str;

        list = new ArrayList<>();
        str = new StringTokenizer(br.readLine());
        str = new StringTokenizer(br.readLine());
        while(str.hasMoreTokens()) {
            list.add(Long.parseLong(str.nextToken()));
        }
        str = new StringTokenizer(br.readLine());
        while(str.hasMoreTokens()) {
            list.add(Long.parseLong(str.nextToken()));
        }
        Collections.sort(list);

        for(Long l : list) {
            sb.append(l).append(" ");
        }


        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }


}