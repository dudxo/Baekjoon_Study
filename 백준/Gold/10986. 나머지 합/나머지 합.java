import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer str;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        str = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(str.nextToken());
        int M = Integer.parseInt(str.nextToken());
        long[] S = new long[N+1];
        long[] C = new long[M];
        long answer = 0;

        str = new StringTokenizer(br.readLine());

        //합 배열 만들기
        for(int i = 1; i <= N; i++){
            S[i] = S[i-1] + Integer.parseInt(str.nextToken());
        }

        //합 배열의 모든 값에 % 연산 수행
        for(int i = 1; i <= N; i++){
            int remainder = (int) (S[i] % M);
            // 구간합 자체가 0이면 이미 M으로 나뉘어 떨어진다는 뜻이기 때문에 정답
            if(remainder == 0) answer++;
            //나머지가 같은 인덱스 개수 카운팅
            C[remainder]++;
        }

        for(int i = 0; i < M; i++){
            if(C[i] > 1){
                //나머지가 같은 인덱스 중 2개를 뽑는 경우의 수 더하기
                answer = answer + (C[i] * (C[i]-1)/2);
            }
        }

        bw.write(String.valueOf(answer));

        bw.flush();
        bw.close();
    }
}