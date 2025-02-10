import java.io.*;

public class Main {

    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        sb.append((int)Math.pow(2, N) - 1).append("\n");
        move(N, 1, 3, sb);

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    private static void move(int no, int x, int y, StringBuilder sb) {
        if(no > 1) {
            move(no-1, x, 6-x-y, sb);
        }
        sb.append(x).append(" ").append(y).append("\n");

        if(no > 1) {
            move(no-1, 6-x-y, y, sb);
        }
    }
}
