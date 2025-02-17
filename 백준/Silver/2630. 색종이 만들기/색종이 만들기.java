import java.io.*;
import java.util.*;

public class Main {

    static int N, white, blue;
    static int[][] map;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer str;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int i = 0; i < N; i++) {
            str = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(str.nextToken());
            }
        }

        solve(0, 0, N, N);

        sb.append(white).append("\n").append(blue);

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    private static void solve(int sx, int sy, int ex, int ey) {
        if(check(sx, sy, ex, ey)) {
            count(sx, sy);
            return;
        }

        int midX = (ex - sx) / 2 + sx;
        int midY = (ey - sy) / 2 + sy;

        solve(sx, sy, midX, midY); // 1사분면
        solve(sx, midY, midX, ey); // 2사분면
        solve(midX, midY, ex, ey); // 3사분면
        solve(midX, sy, ex, midY); // 4사분면
    }

    private static void count(int i, int j) {
        if(map[i][j] == 0) {
            white += 1;
            return;
        }

        blue += 1;
    }

    private static boolean check(int sx, int sy, int ex, int ey) {
        int flag = map[sx][sy];
        for(int i = sx; i < ex; i++) {
            for(int j = sy; j < ey; j++) {
                if(flag != map[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

}