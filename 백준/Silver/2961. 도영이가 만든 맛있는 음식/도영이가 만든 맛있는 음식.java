import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N, answer;
    static ArrayList<int[]> recipes = new ArrayList<>();
    static boolean[] isUsed;
    static int[] sin, jan;



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer str;

        N = Integer.parseInt(br.readLine());
        isUsed = new boolean[N];


        for(int i = 0; i < N; i++) {
            str = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(str.nextToken());
            int j = Integer.parseInt(str.nextToken());

            recipes.add(new int[] {s, j});
        }

        answer = Integer.MAX_VALUE;

        for(int i = 1; i <= recipes.size(); i++) {
            sin = new int[i];
            jan = new int[i];
            solve(0, 0);
        }


        sb.append(answer);

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    private static void solve(int k, int depth) {
        if(depth == sin.length) {
            int mul = 1;
            int sub = 0;
            for(int i = 0; i < depth; i++) {
                mul *= sin[i];
                sub += jan[i];
            }
            answer = Math.min(answer, Math.abs(mul - sub));
            return;
        }

        for(int i = k; i < recipes.size(); i++) {
            int[] recipe = recipes.get(i);
            sin[depth] = recipe[0];
            jan[depth] = recipe[1];

            solve(i+1, depth+1);
        }
    }

}