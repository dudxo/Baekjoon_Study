import java.io.*;
import java.util.*;

public class Main {

    static int[] arr, find;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer str = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(str.nextToken());
        }
        Arrays.sort(arr);       //이진 탐색을 위한 사전 정렬
        int M = Integer.parseInt(br.readLine());
        find = new int[M];
        str = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            find[i] = Integer.parseInt(str.nextToken());
        }
        br.close();

        for(int i : find){
            binarySearch(i);
        }
        System.out.println(sb);

    }

    private static void binarySearch(int i){
        int start = 0;
        int end = arr.length - 1;
        boolean check = false;
        while(start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] > i) {
                end = mid - 1;
            } else if(arr[mid] < i){
                start = mid + 1;
            } else{
                check = true;
                break;
            }
        }

        if(check){
            sb.append("1\n");
        } else{
            sb.append("0\n");
        }
    }
}
