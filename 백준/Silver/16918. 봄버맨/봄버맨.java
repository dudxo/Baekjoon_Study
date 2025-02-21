import java.io.*;
import java.util.*;

public class Main {

    static int R, C, N;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] map;
    static ArrayList<int[]> boom;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer str = new StringTokenizer(br.readLine());

        R = Integer.parseInt(str.nextToken());
        C = Integer.parseInt(str.nextToken());
        N = Integer.parseInt(str.nextToken());

        map = new boolean[R][C];
        boom = new ArrayList<>();

        for(int i = 0; i < R; i++) {
            char[] input = br.readLine().toCharArray();
            for(int j = 0; j < C; j++) {
                if(input[j] == '.') {
                    map[i][j] = false;
                    continue;
                }

                map[i][j] = true;
                boom.add(new int[] {i, j});
            }
        }

        if(N > 1) {
            if (N % 2 == 0) {
                fill();
            } else if (N % 4 == 3) {
                converse();
            } else if(N % 4 == 1) {
                converse2();
            }
        }

        print(sb);

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    private static void converse2() {
        for(int i = 0; i < boom.size(); i++) {
            int[] bArr = boom.get(i);
            int x = bArr[0];
            int y = bArr[1];
            for(int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if(nx < 0 || ny < 0 || nx >= R || ny >= C) {
                    continue;
                }

                map[nx][ny] = true;
            }
        }

        boom = new ArrayList<>();
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                map[i][j] = !map[i][j];
                if(map[i][j]) {
                    boom.add(new int[] {i, j});
                }
            }
        }

        for(int i = 0; i < boom.size(); i++) {
            int[] bArr = boom.get(i);
            int x = bArr[0];
            int y = bArr[1];
            for(int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if(nx < 0 || ny < 0 || nx >= R || ny >= C) {
                    continue;
                }

                map[nx][ny] = true;
            }
        }

        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                map[i][j] = !map[i][j];
            }
        }
    }

    private static void print(StringBuilder sb) {
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(map[i][j]) {
                    sb.append("O");
                    continue;
                }
                sb.append(".");
            }
            sb.append("\n");
        }
    }

    private static void fill() {
        for(int i = 0; i < R; i++) {
            Arrays.fill(map[i], true);
        }
    }

    private static void converse() {
        for(int i = 0; i < boom.size(); i++) {
            int[] bArr = boom.get(i);
            int x = bArr[0];
            int y = bArr[1];
            for(int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if(nx < 0 || ny < 0 || nx >= R || ny >= C) {
                    continue;
                }

                map[nx][ny] = true;
            }
        }

        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                map[i][j] = !map[i][j];
            }
        }
    }

}