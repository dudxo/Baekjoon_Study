import java.io.*;
import java.util.*;

public class Main {

    static int N, M, result;
    static int[] arr;
    static List<Integer> negative, positive, results;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        negative = new ArrayList<>();
        positive = new ArrayList<>();
        results = new ArrayList<>();

        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());

        arr = new int[N];

        str = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(str.nextToken());
        }

        Arrays.sort(arr);

        for(int i = 0; i < N; i++) {
            int num = arr[i];
            if(num < 0) {
                negative.add(num);
                continue;
            }

            positive.add(num);
        }

        Collections.sort(negative);
        while(!negative.isEmpty()) {
            int num = 0;

            for(int i = 0; i < M; i++) {
                if(negative.isEmpty()) break;

                if(i == 0) num += negative.get(0);
                negative.remove(0);
            }
            results.add(Math.abs(num));
        }

        Collections.sort(positive, Collections.reverseOrder()); // 내림차순
        while(!positive.isEmpty()) {
            int num = 0;

            for(int i = 0; i < M; i++) {
                if(positive.isEmpty()) break;
                if(i == 0) num += positive.get(0);
                positive.remove(0);
            }
            results.add(Math.abs(num));
        }

        Collections.sort(results);

        while(results.size() > 1) {
            result += (results.get(0) * 2);
            results.remove(0);
        }

        result += results.get(0);

        bw.write(String.valueOf(result));
        bw.flush();
        br.close();
        bw.close();
    }
}