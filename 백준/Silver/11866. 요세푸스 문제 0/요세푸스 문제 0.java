import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 백준11866 요세푸스 문제0
 * 시간제한 2초, 입력값 범위 (1 ≤ K ≤ N ≤ 1,000)
 * 시간복잡도 O(1), O(N), O(logN), O(N^2), O(NlogN)
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new BufferedReader(new InputStreamReader(System.in)));
        Deque<Integer> deque = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] result = new int[N];
        int k = 0;
        String str = "";

        for (int i = 1; i <= N; i++) {
            deque.add(i);
        }

        while (!deque.isEmpty()) {
            for (int j = 1; j < K; j++) {
                deque.add(deque.pop());
            }
            result[k++] = deque.pop();
        }

        for (int sol : result) {
            str += Integer.toString(sol) + ", ";
        }

        if (str.endsWith(" ")) {
            str = str.substring(0, str.length() - 2);
        }
        System.out.print("<" + str + ">");
    }

}
