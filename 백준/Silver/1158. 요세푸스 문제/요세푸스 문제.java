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

        // 토큰 별 입력값 대입
        int N = Integer.parseInt(st.nextToken());       // 정수의 개수
        int K = Integer.parseInt(st.nextToken());       // 삭제할 개수의 범위?
        int[] result = new int[N];
        int k = 0;
        String str = "";        // 최종 출력값을 저장시킬 변수

        for (int i = 1; i <= N; i++) {
            deque.add(i);       // 1~N까지의 값을 deque에 저장
        }

        while (!deque.isEmpty()) {      // deque가 공백일 때까지
            for (int j = 1; j < K; j++) {
                deque.add(deque.pop());     // K이전까지의 값들은 삭제와 동시에 맨 뒤로 삽입
            }
            result[k++] = deque.pop();      // K번째 값은 삭제 후 return 된 값을 result 배열에 저장
        }

        for (int sol : result) {        // result 배열을 뽑아서 ", "와 합쳐 문자열 str에 저장
            str += Integer.toString(sol) + ", ";
        }

        if (str.endsWith(" ")) {        // 공백으로 끝나면
            str = str.substring(0, str.length() - 2);       // 마지막은 ", "로 끝나기 때문에 2개를 빼야됨
        }
        System.out.print("<" + str + ">");
    }

}
