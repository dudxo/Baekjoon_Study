import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            LinkedList<Character> pw = new LinkedList<>();      // 원본 비밀번호가 담길 리스트
            ListIterator<Character> iter = pw.listIterator();
            String input = br.readLine();        // 원본 비밀번호

            for (int i = 0; i < input.length(); i++) {
                char check = input.charAt(i);
                switch (check) {
                    case '<':
                        if (iter.hasPrevious()) {
                            iter.previous();
                        }
                        break;
                    case '>':
                        if (iter.hasNext()) {
                            iter.next();        // 원본 리스트를 건드리면 에러 발생!!!
                        }
                        break;
                    case '-':
                        if (iter.hasPrevious()) {
                            iter.previous();
                            iter.remove();
                        }
                        break;
                    default:
                        iter.add(check);
                }

            }

            for (char sol : pw) {
                bw.write(sol);
            }
            bw.newLine();
        }
        bw.flush();
    }
}
