import java.io.*;

public class Main {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s1 = br.readLine();
        String s2 = br.readLine();

        if (!s1.contains(s2)) {
            bw.write(String.valueOf(0));
        }
        else
            bw.write(String.valueOf(1));
        br.close();
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}