import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N = 0, max = 0;
    static double sum = 0.0, avg = 0.0;
    static StringTokenizer str;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        str = new StringTokenizer(br.readLine());
        int i = 0;
        while(str.hasMoreTokens()){
            arr[i] = Integer.parseInt(str.nextToken());
            if(arr[i] > max){
                max = arr[i];
            }
            i++;
        }

        for (int a : arr) {
            sum += a;
        }

        avg = sum * 100.0 / max / N;

        bw.write(String.valueOf(avg));
        bw.flush();
        bw.close();
    }
}