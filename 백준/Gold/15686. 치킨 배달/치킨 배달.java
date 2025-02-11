import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N, M, answer;
    static int[] serviceKfc;
    static ArrayList<int[]> homes = new ArrayList<>();
    static ArrayList<int[]> kfc = new ArrayList<>();
    static boolean[][] isUsed;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());

        isUsed = new boolean[N+1][N+1];

        for(int i = 1; i <= N; i++) {
            str = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                int num = Integer.parseInt(str.nextToken());
                if(num == 1) {
                    homes.add(new int[] {i, j});
                    continue;
                }
                if(num == 2) {
                    kfc.add(new int[] {i, j});
                }
            }
        }

        answer = Integer.MAX_VALUE;

        serviceKfc = new int[M];
        solve(0, 0);


        sb.append(answer);

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    private static void solve(int k, int depth) {
        if(depth == M) {
            // 총 치킨 거리 값 계산
            answer = Math.min(answer, calculate());
            return ;
        }

        for(int i = k; i < kfc.size(); i++) {
            serviceKfc[depth] = i;
            solve(i + 1, depth + 1);
        }
    }

    private static int calculate() {
        int totalDistance = 0;
        for(int[] h : homes) {
            int minDistance = Integer.MAX_VALUE;
            int hx = h[0];
            int hy = h[1];
            for(int i : serviceKfc) {
                int[] k = kfc.get(i);
                minDistance = Math.min(minDistance, (Math.abs(hx - k[0]) + Math.abs(hy - k[1])));
            }
            totalDistance += minDistance;
        }

        return totalDistance;
    }

}