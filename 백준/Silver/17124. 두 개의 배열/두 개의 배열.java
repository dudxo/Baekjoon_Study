import java.io.*;
import java.util.*;

public class Main {

    static int T, N, M;
    static int[] A, B, C;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            N = Integer.parseInt(str.nextToken());
            M = Integer.parseInt(str.nextToken());
            A = new int[N];
            C = new int[N];
            B = new int[M];

            str = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(str.nextToken());
            }

            str = new StringTokenizer(br.readLine());
            for(int i = 0; i < M; i++) {
                B[i] = Integer.parseInt(str.nextToken());
            }

            Arrays.sort(A);
            Arrays.sort(B);

            long sum = 0;
            int min = 0;
            for(int i = 0; i < N; i++) {
                while(min < M-1){
                    if(B[min] >= A[i]) {
                        break;
                    }
                    min++;
                }
                if(min == 0) {
                    sum += B[0];
                } else {
                    sum += Math.abs(B[min-1] - A[i]) <= Math.abs(B[min] - A[i]) ? B[min-1] : B[min];
                }
            }

            sb.append(sum).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}