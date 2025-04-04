import java.io.*;
import java.util.*;

public class Main {

    static int N, result;
    static int[] a, b;
    static int[][] map;
    static boolean[] isUsed;
    static List<List<List<Integer>>> groups = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str;

        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        isUsed = new boolean[N+1];

        for(int i = 1; i <= N; i++) {
            str = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(str.nextToken());
            }
        }

        result = Integer.MAX_VALUE;
        for(int i = 1; i <= N/2; i++) {
            a = new int[N-i];
            b = new int[i];
            backTracking(i, 0);
        }

        bw.write(String.valueOf(result));
        bw.flush();
    }

    private static int sum(int[] arr) {
        int st = 0;
        int ed = 1;
        int size = arr.length;

        if(size == 1) return 0;

        int sum = 0;
        while(st < size-1) {
            int x = arr[st];
            int y = arr[ed++];
            sum += map[x][y];
            sum += map[y][x];

            if(ed >= size) {
                st++;
                ed = st+1;
            }
        }

        return sum;
    }

    private static void backTracking(int k, int dept) {
        if(dept == N-k) {
            int index = 0;
            for(int i = 1; i <= N; i++) {
                if(isUsed[i]) continue;

                b[index++] = i;
            }

            result = Math.min(result, Math.abs(sum(a) - sum(b)));
            return;
        }

        for(int i = 1; i <= N; i++) {
            if(dept > 0 && a[dept-1] > i) continue;

            if(!isUsed[i]) {
                a[dept] = i;
                isUsed[i] = true;
                backTracking(k, dept+1);
                isUsed[i] = false;
            }
        }

    }

}