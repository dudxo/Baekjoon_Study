package baekjoon;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 백준2161 카드1
 * 시간 제한 2초, 입력값 범위 정수 N(1 ≤ N ≤ 1,000)
 * 예상 가능 시간복잡도 : O(1),O(longN), O(N), O(N^2), O(NlogN)
 */
public class Baekjoon2161 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Integer> queue = new LinkedList<>();

        int N = 0;
        N = Integer.parseInt(br.readLine());        // 카드 개수
        int num = N/2;
        for (int i = 1; i <= N; i++) {
            if (num > i) {
                queue.addFirst(i);
            } else {
                queue.addLast(i);
            }
        }

        while(!queue.isEmpty()) {      // 카드가 1장 남을 때까지
            bw.write(Integer.toString(queue.pop()));        // 삭제될 카드 + 버퍼 담기
            bw.write(" ");
            queue.addLast(queue.pop());     // 삭제될 카드의 다음 카드는 맨 뒤로 이동(기존 값은 삭제)
        }

        bw.write(Integer.toString(queue.peek()));       // 마지막 남은 카드 버퍼 담기
        bw.flush();
        bw.close();


    }

}
