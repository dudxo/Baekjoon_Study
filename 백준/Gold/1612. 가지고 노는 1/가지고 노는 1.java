import java.io.*;

public class Main {

    static int N;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        int add = 1 % N;
        int j = 1;

        int result = 0;

        if(N % 2 == 0 || N % 5 == 0) {
            result = -1;
        } else {
            while(add != 0) {
                add = (add * 10 + 1) % N;
                j++;
            }
            result = j;
        }

        sb.append(result);

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

}