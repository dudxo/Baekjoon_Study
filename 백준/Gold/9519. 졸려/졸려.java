import java.io.*;
import java.util.*;

public class Main {

    static int X, tempX, count;
    static String word;
    static StringBuilder head, tail;
    static HashMap<String, Integer> mapWord;
    static List<String> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        X = Integer.parseInt(br.readLine());
        tempX = X;
        word = br.readLine();

        head = new StringBuilder();
        tail = new StringBuilder();
        mapWord = new HashMap<>();
        list = new ArrayList<>();
        list.add(word);

        int cnt = 0;
        int size = word.length();
        while(tempX-- > 0) {
            head.setLength(0);
            tail.setLength(0);
            if(size % 2 == 0) {
                for(int i = size-1; i >= 0; i-=2) {
                    tail.append(word.charAt(i));
                }
                for(int i = 0; i < size; i+=2) {
                    head.append(word.charAt(i));
                }
            } else {
                for(int i = size-2; i >= 0; i-=2) {
                    tail.append(word.charAt(i));
                }
                for(int i = 0; i < size; i+=2) {
                    head.append(word.charAt(i));
                }
            }
            head.append(tail);
            word = head.toString();
            list.add(word);

            if(mapWord.containsKey(word)) {
               break;
            }
            mapWord.put(word, cnt++);
        }

        if(tempX > 0) {
            tempX = X % cnt;
            bw.write(list.get(tempX));
        } else {
            bw.write(word);
        }

        bw.flush();
        br.close();
        bw.close();
    }

}