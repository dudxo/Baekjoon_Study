import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static long result;
    static PriorityQueue<Long> pq = new PriorityQueue<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());

        str = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            pq.add(Long.parseLong(str.nextToken()));
        }

        for(int i = 0; i < M; i++) {
            long x = pq.poll();
            long y = pq.poll();

            for(int j = 0; j < 2; j++) {
                pq.add(x+y);
            }
        }

        for(long i : pq) {
            result += i;
        }

        sb.append(result);

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }


}