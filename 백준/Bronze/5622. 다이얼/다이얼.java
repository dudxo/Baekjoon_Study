import java.io.*;
import java.util.*;

public class Main {

    static int ans;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer str;

        String s = br.readLine();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c >= 'A' && c <= 'C') {
                ans += 2;
            } else if (c >= 'D' && c <= 'F'){
                ans += 3;
            } else if (c >= 'G' && c <= 'I'){
                ans += 4;
            } else if (c >= 'J' && c <= 'L'){
                ans += 5;
            } else if (c >= 'M' && c <= 'O'){
                ans += 6;
            } else if (c >= 'P' && c <= 'S'){
                ans += 7;
            } else if (c >= 'T' && c <= 'V'){
                ans += 8;
            } else if (c >= 'W' && c <= 'Z'){
                ans += 9;
            }
            ans += 1;
        }

        sb.append(ans);

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
    }