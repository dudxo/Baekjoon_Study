import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int A, B;
        String str = "";
        while((str = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(str);
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            bw.write(A+B + "\n");
        }
        bw.flush();
        bw.close();
    }
}
