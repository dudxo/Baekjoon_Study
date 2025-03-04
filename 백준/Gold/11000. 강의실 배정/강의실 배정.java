import java.io.*;
import java.util.*;

public class Main {

    static int N, result;
    static int[][] arr;
    static int[] ed;
    static boolean[] isUsed;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer str;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];
        ed = new int[N];
        isUsed = new boolean[N];
        result = 0;

        for(int i = 0; i < N; i++) {
            str = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(str.nextToken());
            int v = Integer.parseInt(str.nextToken());

            arr[i][0] = u;
            arr[i][1] = v;
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            if (!pq.isEmpty() && pq.peek() <= arr[i][0]) {
                pq.poll();
            }
            pq.offer(arr[i][1]);
        }

        sb.append(pq.size());

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

}