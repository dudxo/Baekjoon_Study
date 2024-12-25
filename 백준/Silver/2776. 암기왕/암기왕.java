import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int T, N, M;
    static int[] case1, case2;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer str = new StringTokenizer(br.readLine());
        T = Integer.parseInt(str.nextToken());

        StringBuilder sb = new StringBuilder(M * 2);
        while(T-- > 0) {

            str = new StringTokenizer(br.readLine());
            N = Integer.parseInt(str.nextToken());
            case1 = new int[N];
            str = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                case1[i] = Integer.parseInt(str.nextToken());
            }

            str = new StringTokenizer(br.readLine());
            M = Integer.parseInt(str.nextToken());
            case2 = new int[M];
            str = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                case2[i] = Integer.parseInt(str.nextToken());
            }

            Arrays.sort(case1);

            for (int i = 0; i < M; i++) {
                if (binary_search(case2[i])) {
                    sb.append("1").append("\n");
                } else {
                    sb.append("0").append("\n");
                }
            }
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    private static boolean binary_search(int num) {
        int st = 0;
        int ed = N - 1;

        while(st <= ed) {
            int mid = (st+ed) / 2;
            if(case1[mid] == num) {
                return true;
            }

            if(case1[mid] > num) {
                ed = mid - 1;
            }

            if(case1[mid] < num) {
                st = mid + 1;
            }
        }
        return false;
    }
}