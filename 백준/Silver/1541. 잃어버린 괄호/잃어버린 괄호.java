import static javax.swing.text.html.HTML.Attribute.*;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<Integer> nums;
    static List<String> op;
    static List<String> list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] minus = br.readLine().split("-");

        int result = 0;

        for(int i = 0; i < minus.length; i++) {
            int sum = 0;

            String[] plus = minus[i].split("\\+");

            for(int j = 0; j < plus.length; j++) {
                sum += Integer.parseInt(plus[j]);
            }

            if(i == 0) {
                result = sum;
            } else {
                result -= sum;
            }
        }

        sb.append(result);
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}