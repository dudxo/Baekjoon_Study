import java.io.*;
import java.util.*;
public class Main {

    static int N, M;
    static int[] arr, nums;
    static boolean[] isUsed;
    static StringBuilder sb = new StringBuilder();
    static LinkedHashSet<String> set = new LinkedHashSet<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str = new StringTokenizer(br.readLine());

        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());

        arr = new int[M];
        nums = new int[N];
        isUsed = new boolean[N];

        str = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(str.nextToken());
        }

        Arrays.sort(nums);

        br.close();

        solve(0);

        for(String s : set) {
            sb.append(s).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void solve(int k) {
        if(k == M) {
            set.add(Arrays.toString(arr).replaceAll("\\[", "").replaceAll(",", "").replaceAll("\\]", ""));
            return;
        }

        for(int i = 0; i < N; i++) {
            if(isUsed[i]) {
                continue;
            }
            arr[k] = nums[i];
            isUsed[i] = true;
            solve(k+1);
            isUsed[i] = false;
        }
    }

}