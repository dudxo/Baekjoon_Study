package baekjoon;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 백준2164 카드2
 * 시간 제한 2초, 입력값 범위 정수 N(1 ≤ N ≤ 500,000)
 * 예상 가능 시간복잡도 : O(1),O(longN), O(N), O(N^2), O(NlogN)?
 */
public class Baekjoon2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Integer> queue = new LinkedList<>();

        int N = 0;      // N장 카드
        N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            queue.add(i);       // 1~N까지의 카드 삽입
        }

        while(queue.size() != 1) {      // 카드가 1장 남을 때까지 반복
            queue.pop();        // 최상단을 지우고
            queue.addLast(queue.pop());     // 다음 카드는 맨 아래로 이동, 이동하기 위해서 최상단 위치를 지워줘야됨!
        }

        bw.write(Integer.toString(queue.peek()));
        bw.flush();
        bw.close();


    }
}
