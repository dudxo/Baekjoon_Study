import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static long[] arr;

    static Node[] nodes;
    static class Node implements Comparable<Node> {
        String name;
        long power;

        Node(String name, long power) {
            this.name = name;
            this.power = power;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.power, o.power);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());
        nodes = new Node[N];
        for(int i = 0; i < N; i++) {
            str = new StringTokenizer(br.readLine());
            nodes[i] = new Node(str.nextToken(), Long.parseLong(str.nextToken()));
        }

        arr = new long[M];
        for(int i = 0; i < M; i++) {
            sb.append(sol(Long.parseLong(br.readLine())));
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    private static String sol(Long num) {
        long st = 0;
        long ed = N-1;

        while(st < ed) {
            long mid = (st+ed) / 2;
            if(num <= nodes[(int)mid].power) {
                ed = mid;
            } else {
                st = mid + 1;
            }
        }

        return nodes[(int)st].name+"\n";
    }

}
