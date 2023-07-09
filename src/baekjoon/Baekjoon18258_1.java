package baekjoon;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 백준18258
 * solved
 * queue를 상속받는 deque 사용
 * 23-07-09
 */
public class Baekjoon18258_1 {
    public static void main(String[] args) throws IOException {
        Deque<String> queue = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = 0;
        T = Integer.parseInt(br.readLine());
        String cmd = "";


        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "pop":
                    if (queue.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        bw.write(queue.poll() + "\n");
                    }break;
                case "size":
                    bw.write(Integer.toString(queue.size()));
                    bw.newLine();
                    break;
                case "empty":
                    if (queue.isEmpty()) {
                        bw.write("1\n");
                    } else {
                        bw.write("0\n");
                    }
                    break;
                case "front":
                    if (queue.isEmpty()) {
                        bw.write("-1\n");
                        break;
                    }
                    bw.write(queue.peek() + "\n");
                    break;
                case "back":
                    if (queue.isEmpty()) {
                        bw.write("-1\n");
                        break;
                    }
                    bw.write(queue.peekLast() + "\n");
                    break;
                default:
                    queue.add(st.nextToken());
            }
        }
        bw.flush();
        bw.close();
    }
}

