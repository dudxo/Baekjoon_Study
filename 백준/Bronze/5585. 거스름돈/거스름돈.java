import java.io.*;

public class Main {

    static int[] yen = {500, 100, 50, 10, 5, 1};
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = 1_000 - Integer.parseInt(br.readLine());

        int count = 0;

        for(int i = 0; i < yen.length; i++) {
            if(N / yen[i] != 0) {
                count += (N / yen[i]);
                N = N % yen[i];
            }
        }

        sb.append(count);

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}