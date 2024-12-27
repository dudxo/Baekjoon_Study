import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] cards, arr;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        String[] nums = br.readLine().split(" ");
        for(int i = 0 ; i < N; i++) {
            arr[i] = Integer.parseInt(nums[i]);
        }

        Arrays.sort(arr);

        M = Integer.parseInt(br.readLine());
        cards = new int[M];
        String[] nums2 = br.readLine().split(" ");

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < M; i++) {
            int num = Integer.parseInt(nums2[i]);
            int count = 0;
            if(binary_search(num)) {
                int up = upper_bound(num);
                int low = lower_bound(num);
                count = up - low;
            }
            sb.append(count).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    private static int lower_bound(int num) {
        int st = 0;
        int ed = N;
        while(st < ed) {
            int mid = (st+ed) / 2;
            if(arr[mid] >= num) {
                ed = mid;
            } else {
                st = mid + 1;
            }
        }

        return st;
    }

    private static int upper_bound(int num) {
        int st = 0;
        int ed = N;
        while(st < ed) {
            int mid = (st+ed) / 2;
            if(arr[mid] <= num) {
                st = mid + 1;
            } else {
                ed = mid;
            }
        }

        return ed;
    }

    private static boolean binary_search(int num) {
        int st = 0;
        int ed = N-1;

        while(st <= ed) {
            int mid = (st+ed) / 2;
            if(arr[mid] == num) {
                return true;
            }

            if(arr[mid] < num) {
                st = mid + 1;
            } else {
                ed = mid - 1;
            }
        }

        return false;

    }
}