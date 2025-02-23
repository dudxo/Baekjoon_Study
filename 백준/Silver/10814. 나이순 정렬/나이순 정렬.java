import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static List<Node> lists;
    static class Node implements Comparable<Node> {
        int age;
        String name;
        int id;

        Node(int age, String name, int id) {
            this.age = age;
            this.name = name;
            this.id = id;
        }

        @Override
        public int compareTo(Node o) {
            if(this.age == o.age) {
                return Integer.compare(this.id, o.id);
            }

            return Integer.compare(this.age, o.age);
        }

        @Override
        public String toString() {
            return this.age + " " + this.name;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer str;

        N = Integer.parseInt(br.readLine());
        lists = new ArrayList<>();

        for(int i = 1; i <= N; i++) {
            str = new StringTokenizer(br.readLine());
            lists.add(new Node(Integer.parseInt(str.nextToken()), str.nextToken(), i));
        }

        Collections.sort(lists);

        for(Node node : lists) {
            sb.append(node).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }


}