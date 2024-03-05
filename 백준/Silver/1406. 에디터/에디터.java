import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       List<Character> list = new LinkedList<>();
       ListIterator<Character> cursor = list.listIterator();
       String str = br.readLine();
       for (int i = 0 ; i < str.length(); i++){
           cursor.add(str.charAt(i));
       }
       int M = Integer.parseInt(br.readLine());
       for (int i = 0; i < M; i++){
           StringTokenizer st = new StringTokenizer(br.readLine());
           switch (st.nextToken()) {
               case "L" :
                   if (cursor.hasPrevious()) {
                       cursor.previous();
                   }
                   break;
               case "D" :
                   if (cursor.hasNext()) {
                       cursor.next();
                   }
                   break;
               case "B" :
                   if (cursor.hasPrevious()) {
                       cursor.previous();
                       cursor.remove();
                   }
                   break;
               case "P" :
                   cursor.add(st.nextToken().charAt(0));
                   break;
           }
       }
       for (char c : list) {
           bw.write(c);
       }
       bw.flush();
       bw.close();
    }
}
