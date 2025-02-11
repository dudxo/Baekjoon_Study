import java.io.*;

public class Main {

    static final int NINE = 9, SEVEN = 7;
    static int[] arr, answer;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        arr = new int[NINE];
        answer = new int[SEVEN];
        visited = new boolean[NINE];

        for(int i = 0; i < NINE; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        solve(0, sb);

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    private static boolean solve(int k, StringBuilder sb) {
        if(k == SEVEN) {
            int sum = 0;
            for(int i : answer) {
                sum += i;
            }
            if(sum == 100) {
                for(int i : answer) {
                    sb.append(i).append("\n");
                }
                return true;
            }
            return false;
        }

        for(int i = 0; i < NINE; i++) {
            if(!visited[i]) {
                answer[k] = arr[i];
                visited[i] = true;
                if(solve(k+1, sb)) {
                    return true;
                }
                visited[i] = false;
            }
        }
        return false;
    }

}