import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] T = br.readLine().split(" ");
        int N = Integer.parseInt(T[0]);
        int M = Integer.parseInt(T[1]);
        int K = Integer.parseInt(T[2]);

        int[] num = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            num[i] = num[i - 1] + Integer.parseInt(br.readLine());
        }

        for (int j = 0; j < M + K; j++) {
            String abc[] = br.readLine().split(" ");
            switch (abc[0]) {
                case "1":
                    num[Integer.parseInt(abc[1])] = Math.abs(num[Integer.parseInt(abc[1])] - Integer.parseInt(abc[2]));
                    break;
                case "2":
                    bw.write(Integer.toString(num[Integer.parseInt(abc[2])] - num[Integer.parseInt(abc[1]) - 1]));
                    bw.newLine();
                    break;
            }
        }
        bw.flush();
        bw.close();

    }

}
