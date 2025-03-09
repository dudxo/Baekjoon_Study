import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] arr, arr2;
    static List<Integer> result;
    static boolean[] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        arr2 = new int[N*2];  // 모든 수는 2번 이상 나와야 한다.
        visited = new boolean[N];
        result = new ArrayList<>();
        Arrays.fill(arr2, -1);

        StringTokenizer str = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(str.nextToken());
        }

        Arrays.sort(arr);

        sol();

        if(result.size() == 0) {
            result.add(-1);
        }

        for(int i : result) {
            bw.write(String.valueOf(i));
            bw.write(" ");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    private static void sol() {
        int k = Integer.MIN_VALUE;
        for (int i = 0; i < N * 2; i++) {
            if(arr2[i] == -1) {
                k = i;
                break;
            }
        }


        if(k == Integer.MIN_VALUE) {
            for(int i : arr2) {
                result.add(i);
            }
            return;
        }

        for(int i = 0; i < N; i++) {
            if(visited[i]) continue;

            int num = arr[i];
            int nxt = k+num+1;
            if(nxt >= N*2 || arr2[k] != -1 || arr2[nxt] != -1) continue;

            arr2[k] = num;
            arr2[nxt] = num;
            visited[i] = true;

            sol();
            if(result.size() == N*2) {
                return;
            }

            arr2[k] = -1;
            arr2[nxt] = -1;
            visited[i] = false;
        }
    }
}
