import java.io.*;
import java.util.*;

public class Main {
    static int N, T;
    static int[] scores;
    static ArrayDeque<Integer> dq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer str;

        N = Integer.parseInt(br.readLine());
        scores = new int[N+1];

        T = Integer.parseInt(br.readLine());

        dq = new ArrayDeque<>();
        str = new StringTokenizer(br.readLine());
        for(int i = 0; i < N*2; i++) {
            dq.add(Integer.parseInt(str.nextToken()));
        }

        str = new StringTokenizer(br.readLine());
        while(T-- > 0) {
            int count = Integer.parseInt(str.nextToken());
            for(int i = 0; i < count-1; i++) {
                dq.addLast(dq.removeFirst());
            }

            sb.append(dq.peekFirst()).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
    }

}