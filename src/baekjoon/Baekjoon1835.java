package baekjoon;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 백준1835 카드
 * not solved
 * 틀렸습니다.
 */
public class Baekjoon1835 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Integer> queue = new LinkedList<>();

        int N = 0;
        N = Integer.parseInt(br.readLine());        // 카드 개수

        System.out.println(N/2);
        for (int i = 1; i <= N / 2; i++) {
            queue.addFirst(i);
        }

        for (int i = N; i > N / 2; i--) {
            queue.addLast(i);
        }

        while(!queue.isEmpty()) {      // 카드가 1장 남을 때까지
            bw.write(Integer.toString(queue.pollFirst()));        // 삭제될 카드 + 버퍼 담기
            bw.write(" ");
        }

        bw.flush();
        bw.close();


    }
}
