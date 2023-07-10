import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = 0, M = 0, result = 0;

        String[] NM = br.readLine().split(" ");

        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);

        int[] num = new int[N+1];

        String[] st = br.readLine().split(" ");

        for (int i = 1; i <= N; i++) {
            num[i] = num[i-1] + Integer.parseInt(st[i-1]);
        }

        for (int k = 0; k < M; k++) {
            String[] s = br.readLine().split(" ");
            int i = Integer.parseInt(s[0]);
            int j = Integer.parseInt(s[1]);
            bw.write(Integer.toString(num[j] - num[i-1]));
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }

}
