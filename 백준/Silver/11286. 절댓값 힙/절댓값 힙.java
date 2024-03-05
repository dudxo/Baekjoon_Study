import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       PriorityQueue<Num> absHeap = new PriorityQueue<>();

       int N = Integer.parseInt(br.readLine());
       for (int i = 0; i < N; i++){
           int x = Integer.parseInt(br.readLine());
           if (x == 0) {
               if (!absHeap.isEmpty()) {
                   System.out.println(absHeap.poll().toString());
               } else {
                   System.out.println(0);
               }
               continue;
           }
           absHeap.add(new Num(x));
       }
    }

    static class Num implements Comparable<Num> {
        int num;

        public Num(int num) {
            this.num = num;
        }

        @Override
        public String toString() {
            return String.valueOf(this.num);
        }

        @Override
        public int compareTo(Num o) {
            if (Math.abs(this.num) == Math.abs(o.num)) {
                return this.num < o.num ? -1 : 1;
            } else {
                return Math.abs(this.num) < Math.abs(o.num) ? -1 : 1;
            }
        }
    }
}
