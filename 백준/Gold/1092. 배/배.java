import java.io.*;
import java.util.*;

public class Main {

    static int N, M, result;
    static Integer[] crane;
    static boolean[] isWork;
    static List<Integer> boxs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        crane = new Integer[N];
        isWork = new boolean[N];
        int max = Integer.MIN_VALUE;

        StringTokenizer str = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            crane[i] = Integer.parseInt(str.nextToken());
            max = Math.max(max, crane[i]);
        }

        M = Integer.parseInt(br.readLine());
        boxs = new ArrayList<>();
        str = new StringTokenizer(br.readLine());
        while(str.hasMoreTokens()) {
            boxs.add(Integer.parseInt(str.nextToken()));
        }

        Arrays.sort(crane, Collections.reverseOrder());
        Collections.sort(boxs, Collections.reverseOrder());

        if(boxs.get(0) > max) {
            result = -1;
        } else {
            while (!boxs.isEmpty()) {
                sol();
                result += 1;
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
        br.close();
        bw.close();
    }

    private static void sol() {
        int idx = 0;
        while(idx < N ) {
            binarySearch(crane[idx]);
            idx++;
        }
    }

    private static void binarySearch(int crane) {
        long st = 0;
        long ed = boxs.size();

        while(st < ed) {
            long mid = (st+ed) / 2;
            if(boxs.get((int)mid) <= crane) {
                ed = mid;
            } else {
                st = mid+1;
            }
        }

        if(ed >= boxs.size()) {
            return;
        }

        boxs.remove((int)ed);
    }
}
