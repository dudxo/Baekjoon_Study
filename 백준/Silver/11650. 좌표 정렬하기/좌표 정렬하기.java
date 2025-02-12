import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static class Node implements Comparable<Node> {
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
    }
    static List<Node> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer str;

        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            str = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(str.nextToken());
            int y = Integer.parseInt(str.nextToken());
            list.add(new Node(x, y));
        }

        Collections.sort(list);

        for(Node n : list) {
            sb.append(n.x).append(" ").append(n.y).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

}