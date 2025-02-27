import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static List<Node> list;
    static class Node implements Comparable<Node> {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Node o) {
            if(this.y == o.y) {
                return Integer.compare(this.x, o.x);
            }

            return Integer.compare(this.y, o.y);
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer str;

        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            str = new StringTokenizer(br.readLine());
            list.add(new Node(Integer.parseInt(str.nextToken()), Integer.parseInt(str.nextToken())));
        }

        Collections.sort(list);

        for(Node node : list) {
            sb.append(node.toString()).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }


}