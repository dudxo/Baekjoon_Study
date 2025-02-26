import java.io.*;
import java.util.*;

public class Main {

    static final int INF = Integer.MAX_VALUE;
    static int N, K, result;
    static int[] arr;
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        K = Integer.parseInt(str.nextToken());

        arr = new int[N];

        str = new StringTokenizer(br.readLine());

        int st = INF;
        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(str.nextToken());
            if(num == 1) {
                st = Math.min(i, st);
            }
            arr[i] = num;
        }

        result = INF;

        sol(st);

        sb.append(result == INF ? "-1" : result);

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    private static void sol(int i) {
        if(i == INF) {
            return ;
        }

        int st = i;
        int ed = st+1;
        int count = 1;

        if(1 == K) {
            result = 1;
            return;
        }

        while(ed < N && st < N) {
           if(arr[ed] == 1) {
               q.add(ed);
               count++;
           }

           if(count == K) {
               result = Math.min(result, ed-st+1);
               st = q.poll();
               count -= 1;
           }
           ed++;
        }
    }

}