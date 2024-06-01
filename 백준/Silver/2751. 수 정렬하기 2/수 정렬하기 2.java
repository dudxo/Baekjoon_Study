import java.io.*;
import java.util.*;

public class Main {

    static int[] arr, tmp;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N+1];     //원본 배열
        tmp = new int[N+1];     //정렬을 위해 선언한 배열
        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        merge_sort(1, N);
        for(int i = 1; i <= N; i++){
            bw.write(arr[i] + "\n");
        }
        bw.flush();
        bw.close();

    }

    private static void merge_sort(int s, int e){
        if(e-s <1)
            return;
        int m = s + (e - s) / 2;        //중간값 구하기
        //재귀 방식으로 분할-정복
        merge_sort(s, m);
        merge_sort(m+1, e);
        //병합한 그룹 복사
        for(int i = s; i <= e; i++){
            tmp[i] = arr[i];
        }
        int k = s;
        int index1 = s;     //앞쪽 그룹
        int index2 = m+1;       //뒤쪽 그룹
        //그룹별 크기를 비교하여 원본 배열에 정렬
        while(index1 <= m && index2 <= e){
            if(tmp[index1] > tmp[index2]){
                arr[k] = tmp[index2];
                k++;
                index2++;
            } else{
                arr[k] = tmp[index1];
                k++;
                index1++;
            }
        }
        while(index1 <= m){
            arr[k] = tmp[index1];
            k++;
            index1++;
        }
        while(index2 <= m){
            arr[k] = tmp[index2];
            k++;
            index2++;
        }
    }

}