import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static ArrayList<int[]> homes;
    static Integer[][] dp;



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer str;

        N = Integer.parseInt(br.readLine());
        homes = new ArrayList<>();
        dp = new Integer[N][3];

        for(int i = 0; i < N; i++) {
            str = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(str.nextToken());
            int g = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());

            homes.add(new int[] {r, g, b});
        }

        int answer = Math.min(solve(0, 0), Math.min(solve(1, 0), solve(2, 0)));
        sb.append(answer);

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    private static int solve(int color, int depth) {
        if(depth == N-1) {
            if(color == 0) {
                return homes.get(depth)[0];
            }
            if(color == 1) {
                return homes.get(depth)[1];
            }
            return homes.get(depth)[2];
        }


        if(dp[depth][color] == null) {
            if (color == 0) {
                dp[depth][color] = Math.min(solve(1, depth + 1), solve(2, depth + 1)) + homes.get(depth)[0];
            } else if (color == 1) {
                dp[depth][color] = Math.min(solve(0, depth + 1), solve(2, depth + 1)) + homes.get(depth)[1];
            } else {
                dp[depth][color] = Math.min(solve(0, depth + 1), solve(1, depth + 1)) + homes.get(depth)[2];
            }
        }


        return dp[depth][color];
    }

}