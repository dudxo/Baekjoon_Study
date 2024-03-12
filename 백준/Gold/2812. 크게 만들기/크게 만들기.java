import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       StringTokenizer st = new StringTokenizer(br.readLine());
       int n = Integer.parseInt(st.nextToken());
       int k = Integer.parseInt(st.nextToken());
       Stack<Integer> stack = new Stack<>();
       String str = br.readLine();
       for(int i = 0; i < n; i++){
           int op = str.charAt(i) - '0';
           while (!stack.isEmpty() && stack.peek() < op && k > 0) {
               stack.pop();
               k--;
           }
           stack.add(op);
       }
       if (k > 0) {
           while (k != 0) {
               stack.pop();
               k--;
           }
        }
       StringBuilder answer = new StringBuilder();
       for(int i : stack){
           answer.append(i);
       }
       System.out.println(answer.toString());
    }

}
