package baekjoon;

import java.io.*;

/**
 * 구간 합 구하기4
 * 시간제한 1초, 입력값의 범위
 * 1 ≤ N ≤ 100,000
 * 1 ≤ M ≤ 100,000
 * 1 ≤ i ≤ j ≤ N
 * 가능 시간복잡도 O(NlogN) 이하
 */
public class Baekjoon11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = 0, M = 0, result = 0;

        String[] NM = br.readLine().split(" ");     // ex. 정수형 3 4를 입력받으면 " "를 이용해 짤라서 배열에 저장

        N = Integer.parseInt(NM[0]);        // 각 배열의 값을 원하는 곳에 저장
        M = Integer.parseInt(NM[1]);

        int[] num = new int[N+1];
        // 문제에서 구간의 범위(index)는 '1 ≤ i ≤ j ≤ N'이기 때문에
        // 0번지가 아닌 1번지부터 시작하는게 계산이 편해진다. 그렇기에 수 N+1개의 방을 만들어야 된다.
        // 0번지 측 조기화 되지 않는 곳의 값은 0으로 초기화가 되어있음.

        String[] st = br.readLine().split(" ");

        for (int i = 1; i <= N; i++) {
            num[i] = num[i-1] + Integer.parseInt(st[i-1]);
            // 구간은 배열 앞번지의 값과 자신의 값을 더한 값이 되기 때문에 해당 식을 사용한다.
        }

        for (int k = 0; k < M; k++) {
            String[] s = br.readLine().split(" ");
            int i = Integer.parseInt(s[0]);
            int j = Integer.parseInt(s[1]);
            bw.write(Integer.toString(num[j] - num[i-1]));
            // i~j 구간 합은 누적된 값이 저장된 배열 num에서 j - (i-1)을 하면 순수 i~j구간의 합이 나오게 된다.
            // ex. 1 3의 구간은 [배열 index, 값]으로 표기
            // [0,0], [1,5], [2,9], [3,12], [4,14], [5,15]일 때 index 1~3의 합은 구간에 포함되지 않는 index의 최대 합과 빼주면 된다.
            // 즉, 포함되지 않는 index의 최대 합은 구간의 최소 값인 i-1을 나타내니 num[j] - num[i-1]을 계산하면 된다.
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}
