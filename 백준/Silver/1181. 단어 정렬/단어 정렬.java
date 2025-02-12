import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static List<Node> words = new ArrayList<>();

    static class Node implements Comparable<Node> {
        String word;

        Node(String word) {
            this.word = word;
        }

        @Override
        public int compareTo(Node o) {
            if(this.word.length() != o.word.length()) {
                return this.word.length() - o.word.length();
            }

            return this.word.compareTo(o.word);
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        for(int i = 0; i < N; i++) {
            set.add(br.readLine());
        }


        for(String word : set) {
            words.add(new Node(word));
        }
        Collections.sort(words);

        for(Node word : words) {
            sb.append(word.word).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}