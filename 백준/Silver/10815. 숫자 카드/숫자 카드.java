import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] cards, arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        cards = new int[N];
        str = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(str.nextToken());
        }

        str = new StringTokenizer(br.readLine());
        M = Integer.parseInt(str.nextToken());
        arr = new int[M];
        str = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(str.nextToken());
        }

        Arrays.sort(cards);

        StringBuilder sb = new StringBuilder(N*2);
        for(int i = 0; i < M; i++) {
            if(binary_search(arr[i])) {
                sb.append("1").append(" ");
            } else {
                sb.append("0").append(" ");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    private static boolean binary_search(int num) {
        int st = 0;
        int ed = N - 1;

        while(st <= ed) {
            int mid = (st+ed) / 2;
            if(cards[mid] == num) {
                return true;
            }

            if(cards[mid] > num) {
                ed = mid - 1;
            }

            if(cards[mid] < num) {
                st = mid + 1;
            }
        }
        return false;
    }
}