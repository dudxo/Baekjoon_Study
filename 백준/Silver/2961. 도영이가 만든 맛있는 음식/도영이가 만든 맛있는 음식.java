import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N, answer, mul, sum;
    static ArrayList<int[]> recipes = new ArrayList<>();
    static int[] sin, jan;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer str;

        N = Integer.parseInt(br.readLine());

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
            solve(0, 0, i);
        }
        
        sb.append(answer);

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    private static void solve(int start, int depth, int end) {
        if(depth == end) {
            answer = Math.min(answer, calculate(depth));
            return;
        }

        for(int i = start; i < recipes.size(); i++) {
            int[] recipe = recipes.get(i);
            sin[depth] = recipe[0];
            jan[depth] = recipe[1];

            solve(i+1, depth+1, end);
        }
    }

    private static int calculate(int depth) {
        mul = 1;
        sum = 0;
        for(int i = 0; i < depth; i++) {
            mul *= sin[i];
            sum += jan[i];
        }

        return Math.abs(mul - sum);
    }
}