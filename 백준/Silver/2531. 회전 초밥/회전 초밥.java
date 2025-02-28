import java.io.*;
import java.util.*;

public class Main {

    static final int INF = Integer.MIN_VALUE;
    static int N, d, k, c, result;
    static int[] arr, eat;
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer str;

        result = INF;

        str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        d = Integer.parseInt(str.nextToken());
        k = Integer.parseInt(str.nextToken());
        c = Integer.parseInt(str.nextToken());

        arr = new int[N*2];
        eat = new int[k];

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int i = N; i < N*2; i++) {
            arr[i] = arr[i%N];
        }

        sol();

        sb.append(result);

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    private static void sol() {
        int st = 0;
        int ed = 1;
        int count = 0;

        q.add(arr[st]);
        if(arr[st] != c) {
            count += 1;
        }

        while(st < N*2 && ed < N*2) {
            if(ed - st == k) {
                result = Math.max(result, count+1);
                int tmp = q.poll();
                if(!q.contains(tmp) && tmp != c) {
                    count -= 1;
                }
            }

            if(ed - st < k) {
                if(arr[ed] != c && !q.contains(arr[ed])) {
                    count +=1;
                }
                q.add(arr[ed]);
                ed++;
            } else {
                st++;
            }
        }

        if(ed - st == k) {
            result = Math.max(result, count);
            count = setCount();
            q.poll();
        }
    }

    private static int setCount() {
        Set<Integer> set = new HashSet<>();
        for(int i : q) {
            set.add(i);
        }

        return set.size();
    }

}