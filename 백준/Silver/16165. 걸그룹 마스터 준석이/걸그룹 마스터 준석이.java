import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static HashMap<String, List<String>> teamMap = new HashMap<>();
    static HashMap<String, String> memberMap = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());

        while(N-- > 0) {
            String team = br.readLine();
            int mCount = Integer.parseInt(br.readLine());
            List<String> names = new ArrayList<>();

            for(int i = 0; i < mCount; i++) {
                String name = br.readLine();
                names.add(name);
                memberMap.put(name, team);
            }

            Collections.sort(names);
            teamMap.put(team, names);
        }

        while(M-- > 0) {
            String question = br.readLine();
            int type = Integer.parseInt(br.readLine());

            switch (type) {
                case 0 : 
                    List<String> names = teamMap.get(question);
                    for(String name : names) {
                        sb.append(name).append("\n");
                    }
                    break;
                case 1 :
                    String team = memberMap.get(question);
                    sb.append(team).append("\n");
                    break;
            }
        }


        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

}