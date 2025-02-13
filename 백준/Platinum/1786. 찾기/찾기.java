import java.io.*;
import java.util.*;

public class Main {

    static int st, ed, count, totalLen;
    static String text;
    static String pattern;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        text = br.readLine();
        pattern = br.readLine();

        kmp(text, pattern, sb);
        sb.insert(0, count+"\n");

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    private static void kmp(String text, String pattern, StringBuilder sb) {
        char[] texts = text.toCharArray();
        char[] patterns = pattern.toCharArray();
        int[] makeTable = table(pattern);

        int k = 0;

        for(int i = 0; i < texts.length; i++) {
           while(k > 0 && texts[i] != patterns[k]) {
               k = makeTable[k-1];
           }
           if(texts[i] == patterns[k]) {
               if(k == patterns.length-1) {
                   count++;
                   k = makeTable[k];
                   sb.append(i-patterns.length+2).append(' ');
               } else {
                   k++;
               }
           }
        }
        totalLen += texts.length+1;
    }

    private static int[] table(String pattern) {
        char[] patterns = pattern.toCharArray();
        int[] table = new int[patterns.length];
        int k = 0;

        for(int i = 1; i < patterns.length; i++) {
            while(k > 0 && patterns[i] != patterns[k]) {
                k = table[k-1];
            }
            if(patterns[i] == patterns[k]) {
                table[i] = ++k;
            }
        }
        return table;
    }

}