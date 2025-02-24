import java.io.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        while(true) {
            StringBuffer sbf = new StringBuffer(br.readLine());
            if("0".equals(sbf.toString())) {
                break;
            }

            String reverse = new String(sbf.toString());
            sbf.reverse().toString();
            if(reverse.equals(sbf.toString())) {
                sb.append("yes\n");
                continue;
            }

            sb.append("no\n");
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

}