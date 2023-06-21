import java.io.*;

/**
 * 백준 16916문제
 * 27% 시간 초과
 * 코드 길이 가장 짧음
 */
public class Algorithm_3_3 {
    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s1 = br.readLine();
        String s2 = br.readLine();

        if (s1.contains(s2)) {
            bw.write(String.valueOf(1));
        }
        else
            bw.write(String.valueOf(0));
        br.close();
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        new Algorithm_3_3().solution();
    }
}
