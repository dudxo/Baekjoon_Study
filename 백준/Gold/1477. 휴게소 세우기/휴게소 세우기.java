import java.io.*;
import java.util.*;

public class Main {
    static int N, M, L;
    static int[] path, arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer str;


        str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());
        L = Integer.parseInt(str.nextToken());

        path = new int[N+2];
        path[0] = 0;
        path[N+1] = L;

        str = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            path[i] = Integer.parseInt(str.nextToken());
        }

        Arrays.sort(path);
        arr = new int[N+1];
        for(int i = 0; i <= N; i++) {
            arr[i] = path[i+1] - path[i];
        }

        sb.append(binarySearch());

        bw.write(sb.toString());
        bw.flush();
    }

    private static int binarySearch() {
        int st = 1;
        int ed = L-1;

        while(st <= ed) {
            int mid = (st+ed+1) / 2;
            if(sol(mid)) st = mid+1;
            else ed = mid-1;
        }
        return st;
    }

    private static boolean sol(int mid) {
        int count = 0;
        for(int i = 0; i <= N; i++) {
            count += (arr[i]-1) / mid;
        }

        return count > M;
    }
}