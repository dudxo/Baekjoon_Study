import java.io.*;
import java.util.*;

public class Main {

    static int N, M, box, count;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());

        box = M;
        count = 0;
        int book = 0;
        if(N != 0) {
            str = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                book = Integer.parseInt(str.nextToken());

                if (box - book > 0) {
                    box -= book;
                } else if (box - book == 0) {
                    box = M;
                    count += 1;
                } else {
                    box = M - book;
                    count += 1;
                }
            }
        }

        // box != M이라는건 박스에 물건이 담겨져 있다는 뜻.
        if(box != M) {
            count += 1;
        }

        sb.append(count);

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }


}