import java.io.*;
import java.util.*;

public class Main {

    static int[] arr;
    static int start_index = 0, end_index = 0, max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer str = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(str.nextToken());
        int M = Integer.parseInt(str.nextToken());
        arr = new int[N];
        str = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(str.nextToken());
        }

        Arrays.sort(arr);

        for(int i = 0; i < N-2; i++){
            int sum = 0;
            for(int j = i+1; j < N-1; j++){
                for(int k= j+1; k<N; k++){
                    sum = arr[i] + arr[j] + arr[k];
                    if(sum > max && sum <= M){
                        max = sum;
                    }
                }
            }
        }
        bw.write(String.valueOf(max));

        bw.flush();
        bw.close();
    }

}