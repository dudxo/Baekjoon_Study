import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] now;
    static char[][] map;

    /**
     *
     * '.' - 빈칸, '/ 또는 \' - 행성, 'C' - 블랙홀, 'V' - 보이저 위치
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str;

        now = new int[2];

        str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());
        map = new char[N][M];

        for(int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        str = new StringTokenizer(br.readLine());
        now[0] = Integer.parseInt(str.nextToken()) - 1;
        now[1] = Integer.parseInt(str.nextToken()) - 1;

        int result = Integer.MIN_VALUE;
        int cur = 0;
        for(int i = 0; i < 4; i++) {
            //상하좌우 순
            int sec = determine(i);
            if(result < sec) {
                result = sec;
                cur = i;
            }
        }
        bw.write(print(cur));
        if(result == Integer.MAX_VALUE) bw.write("Voyager");
        else bw.write(String.valueOf(result));



        bw.flush();
    }

    private static String print(int cur) {
        switch (cur) {
            case 0 : return "U\n";
            case 1 : return "R\n";
            case 2 : return "D\n";
            case 3 : return "L\n";
        }
        return "";
    }

    private static int determine(int index) {
        int time = 0;
        switch (index) {
            case 0:
                time = sol('U');
                break;
            case 1:
                time = sol('R');
                break;
            case 2:
                time = sol('D');
                break;
            case 3:
                time = sol('L');
                break;
        }
        return time;
    }

    private static int sol(char cur) {
        int x = now[0];
        int y = now[1];
        int time = 1;
        while(true) {
            if(time > N*M*2) return Integer.MAX_VALUE;
            switch (cur) {
                case 'U':
                    if(x-1 < 0 || map[x-1][y] == 'C') return time;
                    x -= 1;
                    if(map[x][y] == '\\') cur = 'L';
                    if(map[x][y] == '/') {
                        cur = 'R';
                    }
                    break;
                case 'D':
                    if(x+1 >= N || map[x+1][y] == 'C') return time;
                    x += 1;
                    if(map[x][y] == '\\') cur = 'R';
                    if(map[x][y] == '/') cur = 'L';
                    break;
                case 'R':
                    if(y+1 >= M || map[x][y+1] == 'C') return time;
                    y += 1;
                    if(map[x][y] == '\\') cur = 'D';
                    if(map[x][y] == '/') cur = 'U';
                    break;
                case 'L':
                    if(y-1 < 0 || map[x][y-1] == 'C') return time;
                    y -= 1;
                    if(map[x][y] == '\\') cur = 'U';
                    if(map[x][y] == '/') cur = 'D';
                    break;
            }
            time++;
        }
    }

}