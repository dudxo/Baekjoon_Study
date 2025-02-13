import java.io.*;
import java.util.*;

public class Main {

    static int T;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            LinkedList<Character> keys = new LinkedList<>();
            ListIterator<Character> cur = keys.listIterator();
            String input = br.readLine();

            for(int i = 0; i < input.length(); i++) {
                switch(input.charAt(i)) {
                    case '<':
                        if(cur.hasPrevious()) {
                            cur.previous();
                        }
                        break;
                    case '>':
                        if(cur.hasNext()) {
                            cur.next();
                        }
                        break;
                    case '-':
                        if(cur.hasPrevious()) {
                            cur.previous();
                            cur.remove();
                        }
                        break;
                    default:
                        cur.add(input.charAt(i));
                }
            }

            for(char c : keys) {
                sb.append(c);
            }
            sb.append("\n");
        }

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }


}