import java.io.*;

public class Main {

    static int x, y;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        x = Integer.parseInt(br.readLine());
        y = Integer.parseInt(br.readLine());

        bw.write(String.valueOf(sol()));

        bw.flush();
        br.close();
        bw.close();
    }

    private static int sol() {
        if(x > 0) {
            if(y > 0) {
                return 1;
            }
            return 4;
        }

        if(y > 0) return 2;

        return 3;
    }
}