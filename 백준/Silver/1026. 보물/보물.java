import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static Integer[] A, B;
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        A = new Integer[N];
        B = new Integer[N];

        StringTokenizer str = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(str.nextToken());
        }

        str = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            B[i] = Integer.parseInt(str.nextToken());
        }

        Arrays.sort(A, Collections.reverseOrder());
        Arrays.sort(B);

        int result = 0;
        for(int i = 0; i < N; i++) {
            result += A[i] * B[i];
        }

        sb.append(result);
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}