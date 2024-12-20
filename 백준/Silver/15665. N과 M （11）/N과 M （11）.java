import java.io.*;
import java.util.*;
public class Main {

    static int N, M;
    static int[] arr, nums;
    static LinkedHashSet<String> set = new LinkedHashSet<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str = new StringTokenizer(br.readLine());

        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());

        arr = new int[M];
        nums = new int[N];

        str = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(str.nextToken());
        }

        Arrays.sort(nums);

        br.close();

        solve(0);

        for(String s : set) {
            bw.write(s);
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }

    private static void solve(int k) {
        if(k == M) {
            StringBuilder sb = new StringBuilder();
            for(int i : arr) {
                sb.append(i).append(" ");
            }
            set.add(sb.toString());
            return;
        }

        for(int i = 0; i < N; i++) {
            arr[k] = nums[i];
            solve(k+1);
        }
    }

}