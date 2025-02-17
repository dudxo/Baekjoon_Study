import java.io.*;
import java.util.*;

public class Main {

    static int N, count;
    static ArrayList<Integer> lowMan, highMan, lowWoman, highWoman;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int tall = 0;
        count = 0;
        N = Integer.parseInt(br.readLine());
        lowMan = new ArrayList<>();
        highMan = new ArrayList<>();
        lowWoman = new ArrayList<>();
        highWoman = new ArrayList<>();

        StringTokenizer str;
        str = new StringTokenizer(br.readLine());

        while(str.hasMoreTokens()) {
            tall = Integer.parseInt(str.nextToken());

            if(tall < 0) {
                lowMan.add(Math.abs(tall)); // 자기보다 작은 사람
                continue;
            }

            highMan.add(tall);    // 자기보다 큰 사람
        }

        str = new StringTokenizer(br.readLine());

        while(str.hasMoreTokens()) {
            tall = Integer.parseInt(str.nextToken());

            if(tall < 0) {
                lowWoman.add(Math.abs(tall));
                continue;
            }

            highWoman.add(tall);
        }

        Collections.sort(lowMan);
        Collections.sort(highMan);
        Collections.sort(lowWoman);
        Collections.sort(highWoman);

        int w = 0, m = 0;

        while(m < highMan.size() && w < lowWoman.size()) {
            if(highMan.get(m) >= lowWoman.get(w)) {
                w += 1;
                continue;
            }

            w++;
            m++;

            count += 1;
        }

        w = 0;
        m = 0;

        while(m < lowMan.size() && w < highWoman.size()) {
            if(lowMan.get(m) <= highWoman.get(w)) {
                m += 1;
                continue;
            }

            w++;
            m++;

            count += 1;
        }

        sb.append(count);

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }


}