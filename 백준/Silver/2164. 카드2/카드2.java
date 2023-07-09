import java.io.*;
import java.util.Deque;
import java.util.LinkedList;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Integer> queue = new LinkedList<>();

        int N = 0;
        N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        while(queue.size() != 1) {
            queue.pop();
            queue.addLast(queue.pop());
        }

        bw.write(Integer.toString(queue.peek()));
        bw.flush();
        bw.close();


    }

}
