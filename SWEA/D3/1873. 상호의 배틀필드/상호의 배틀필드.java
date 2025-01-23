import java.io.*;
import java.util.*;

public class Solution {

    static char[][] map;
    static int T, N, H, W;
    static int x, y;
    static char[] command;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        int t = 0;
        while(t++ < T) {
            sb.append("#").append(t).append(" ");
            StringTokenizer str = new StringTokenizer(br.readLine());
            H = Integer.parseInt(str.nextToken());
            W = Integer.parseInt(str.nextToken());
            map = new char[H][W];

            for(int i = 0; i < H; i++) {
                String st = br.readLine();
                for(int j = 0; j < W; j++) {
                    map[i][j] = st.charAt(j);
                    if(isTank(map[i][j])) {
                        x = i;
                        y = j;
                    }
                }
            }

            N = Integer.parseInt(br.readLine());
            command = new char[N];
            command = br.readLine().toCharArray();

            play();

            print(sb);
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    private static void print(StringBuilder sb) {
        for(int i = 0; i < H; i++) {
            for(int j = 0; j < W; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
    }

    private static boolean isTank(char c) {
        return c == '^' || c == 'v' || c == '<' || c == '>';
    }

    private static void play() {
        for(int i = 0; i < N; i++) {
            char cmd = command[i];

            if(isShot(cmd)) {
                shot();
                continue;
            }

            if(isMoveCmd(cmd)) {
                move(cmd);
            }
        }
    }

    private static void move(char cmd) {
        switch (cmd) {
            case 'U':
                map[x][y] = '^';
                if(x != 0 && isPlain(x-1, y)) {
                    map[x-1][y] = '^';
                    map[x][y] = '.';
                    x = x-1;
                }
                break;
            case 'R':
                map[x][y] = '>';
                if(y != W-1 && isPlain(x, y+1)) {
                    map[x][y+1] = '>';
                    map[x][y] = '.';
                    y = y+1;
                }
                break;
            case 'D':
                map[x][y] = 'v';
                if(x != H-1 && isPlain(x+1, y)) {
                    map[x+1][y] = 'v';
                    map[x][y] = '.';
                    x = x+1;
                }
                break;
            case 'L':
                map[x][y] = '<';
                if(y != 0 && isPlain(x, y-1)) {
                    map[x][y-1] = '<';
                    map[x][y] = '.';
                    y = y-1;
                }
                break;
        }
    }

    private static boolean isPlain(int x, int y) {
        return map[x][y] == '.';
    }

    private static void shot() {
        char cursor = map[x][y];
        switch (cursor) {
            case '^':
                if(x != 0) {
                    for(int i = x-1; i >= 0; i--) {
                        char next = map[i][y];

                        // 위쪽 방향이 벽이 아니라면 포탄 계속 직진
                        if(next != '*' && next != '#') {
                            continue;
                        }

                        // 벽돌 벽이라면 벽은 파괴되고 포탄 소멸
                        if(next == '*') {
                            map[i][y] = '.';
                            break;
                        }

                        // 강철 벽은 포탄만 소멸
                        if(next == '#') {
                            break;
                        }
                    }
                }
                break;
            case '>':
                if(y != W-1) {
                    for (int i = y + 1; i <= W - 1; i++) {
                        char next = map[x][i];

                        // 위쪽 방향이 벽이 아니라면 포탄 계속 직진
                        if (next != '*' && next != '#') {
                            continue;
                        }

                        // 벽돌 벽이라면 벽은 파괴되고 포탄 소멸
                        if (next == '*') {
                            map[x][i] = '.';
                            break;
                        }

                        // 강철 벽은 포탄만 소멸
                        if (next == '#') {
                            break;
                        }
                    }
                }
                break;
            case 'v':
                if(x != H-1) {
                    for (int i = x + 1; i <= H - 1; i++) {
                        char next = map[i][y];

                        // 위쪽 방향이 벽이 아니라면 포탄 계속 직진
                        if (next != '*' && next != '#') {
                            continue;
                        }

                        // 벽돌 벽이라면 벽은 파괴되고 포탄 소멸
                        if (next == '*') {
                            map[i][y] = '.';
                            break;
                        }

                        // 강철 벽은 포탄만 소멸
                        if (next == '#') {
                            break;
                        }
                    }
                }
                break;
            case '<':
                if(y != 0) {
                    for(int i = y-1; i >= 0; i--) {
                        char next = map[x][i];

                        // 위쪽 방향이 벽이 아니라면 포탄 계속 직진
                        if(next != '*' && next != '#') {
                            continue;
                        }

                        // 벽돌 벽이라면 벽은 파괴되고 포탄 소멸
                        if(next == '*') {
                            map[x][i] = '.';
                            break;
                        }

                        // 강철 벽은 포탄만 소멸
                        if(next == '#') {
                            break;
                        }
                    }
                }
                break;
        }
    }


    private static boolean isMoveCmd(char cmd) {
        return cmd == 'U' || cmd == 'D' || cmd == 'L' || cmd == 'R';
    }

    private static boolean isShot(char cmd) {
        return cmd == 'S';
    }
}