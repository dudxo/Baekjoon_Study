import java.io.*;
import java.util.*;

public class Main {

    static int N, M, result;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] visited;
    static char[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer str = new StringTokenizer(br.readLine());

        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());
        map = new char[N][M];

        for(int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i <= N-8; i++) {
            for(int j = 0; j <= M-8; j++) {
                min = Math.min(min, change(i, j));
            }
        }

        sb.append(min);

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    private static int change(int x, int y) {
        int bCount = 0;
        int wCount = 0;

        for(int i = 0; i < 8; i++) {
            for(int j = 0; j <8; j++) {
                char base = map[x+i][y+j];
                char color = ((i + j) % 2 == 0) ? 'B' : 'W';

                if(base != color) {
                    bCount++;
                    continue;
                }
                wCount++;
            }
        }

        return Math.min(bCount, wCount);
    }

}