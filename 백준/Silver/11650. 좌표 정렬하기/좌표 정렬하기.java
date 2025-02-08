import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static Node[] arr;
    public static class Node implements Comparable<Node> {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Node o) {
            if(this.x == o.x) {
                return Integer.compare(this.y, o.y);
            }
            return Integer.compare(this.x, o.x);
        }

        @Override
        public String toString() {
            return x + " " + y + "\n";
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer str;

        N = Integer.parseInt(br.readLine());
        arr = new Node[N];

        for(int i = 0; i < N; i++) {
            str = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(str.nextToken());
            int y = Integer.parseInt(str.nextToken());

            arr[i] = new Node(x, y);
        }

        Arrays.sort(arr);
        for(Node n : arr) {
            sb.append(n.toString());
        }


        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }


}