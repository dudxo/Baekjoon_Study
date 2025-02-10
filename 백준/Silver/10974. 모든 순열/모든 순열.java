import java.io.*;

public class Main {

    static int N;
    static int[] arr;
    static boolean[] isUsed;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        isUsed = new boolean[N+1];

        backTracking(0, sb);

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    private static void backTracking(int k, StringBuilder sb) {
        if(k == N) {
            for(int i = 1; i <= N; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 1; i <= N; i++) {
            if(!isUsed[i]) {
                arr[k+1] = i;
                isUsed[i] = true;
                backTracking(k+1, sb);
                isUsed[i] = false;
            }
        }
    }
}
