import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                if (!heap.isEmpty()) {
                    wr.write(heap.poll() + "\n");
                    continue;
                }
                wr.write(0 + "\n");
            }
            heap.add(num);
        }
        wr.flush();
        wr.close();
    }
}
