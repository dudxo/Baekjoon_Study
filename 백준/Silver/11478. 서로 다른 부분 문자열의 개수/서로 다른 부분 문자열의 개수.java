import java.io.*;
import java.util.*;

public class Main {

    static int st, ed, len;
    static HashMap<String, String> map = new HashMap<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();

        len = str.length();

        st = 0;
        ed = 0;
        for(int i = 0; i < len; i++) {
            st = 0;
            ed = st + i;
            while(ed < len) {
                String sub = str.substring(st, ed+1);
                map.put(sub, sub);
                ed += 1;
                st = ed - i;
            }
        }

        sb.append(map.size());

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

}