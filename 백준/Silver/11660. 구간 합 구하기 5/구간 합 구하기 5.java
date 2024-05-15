import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer str;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = 0 , M = 0;
        str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());
        int[][] arr = new int[N+1][N+1];
        int[][] sum = new int[N+1][N+1];

        //원본 배열
        for(int i = 1; i <= N; i++){
            str = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                arr[i][j] = Integer.parseInt(str.nextToken());
            }
        }

        //합 배열
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                sum[i][j] = sum[i][j-1] + sum[i-1][j] - sum[i-1][j-1] + arr[i][j];
            }
        }

        //구간 합 배열
        for(int i = 0; i < M; i++) {
            str = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(str.nextToken());
            int y1 = Integer.parseInt(str.nextToken());
            int x2 = Integer.parseInt(str.nextToken());
            int y2 = Integer.parseInt(str.nextToken());

            int result = sum[x2][y2] - sum[x1 - 1][y2] - sum[x2][y1 - 1] + sum[x1 - 1][y1 - 1];
            bw.write(Integer.toString(result) + "\n");
        }

        bw.flush();
        bw.close();
    }
}