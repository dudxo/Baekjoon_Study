import java.io.*;
import java.util.*;

public class Main {

    static final String DANCER = "ChongChong";
    static int N, result;
    static HashMap<String, Boolean> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str;

        map = new HashMap<>();

        N = Integer.parseInt(br.readLine());

        String sb1 = "", sb2 = "";
        while(N-- > 0) {
            str = new StringTokenizer(br.readLine());

            sb1 = str.nextToken();
            sb2 = str.nextToken();

            if(Objects.isNull(map.get(sb1))) map.put(sb1.toString(), false);
            if(Objects.isNull(map.get(sb2))) map.put(sb2.toString(), false);

            if(sb1.toString().equals(DANCER)) map.put(sb1.toString(), true);
            if(sb2.toString().equals(DANCER)) map.put(sb2.toString(), true);

            if(map.get(sb1)) map.put(sb2.toString(), true);
            if(map.get(sb2)) map.put(sb1.toString(), true);
        }

        result = 0;
        for(String name : map.keySet()) {
            if(map.get(name)) result++;
        }

        bw.write(String.valueOf(result));
        bw.flush();
    }

}