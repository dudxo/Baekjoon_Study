package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 백준15552 빠른 A+B
 * sol
 */
public class Baekjoon15552 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());     // Integer로 형변환


        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());       // Token마다 잘라 Integer로 형변환
            int B = Integer.parseInt(st.nextToken());
            int sum = A + B;
            bw.write(String.valueOf(sum));      // Buffer에 String 형변환 된 sum 저장
            bw.newLine();       // 개행 추가
        }
        bw.flush();     // 버퍼 비윅
    }
}
