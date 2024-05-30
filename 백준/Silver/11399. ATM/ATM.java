import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int[] arr, hap;
    static int index = 0, insert_index = 0, answer = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        hap = new int[N];

        StringTokenizer str = new StringTokenizer(br.readLine());

        //각 사람의 인출 시간 입력
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(str.nextToken());
        }

        //선택 정렬
        for(int i = 1; i < N; i++){
            index = arr[i];
            insert_index = i;
            for(int j = i - 1; j >= 0; j--){
                if(arr[i] < arr[j]){
                    insert_index = j;
                }
            }
            if(insert_index != i){
                for(int k = i; insert_index < k; k--){
                    arr[k] = arr[k-1];
                }
            }
            arr[insert_index] = index;
        }

        //합 구간을 통해 인원별 걸리는 시간 계산
        hap[0] = arr[0];
        for(int i = 1; i < N; i++){
            hap[i] = arr[i] + hap[i - 1];
        }

        for(int i : hap){
            answer += i;
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }

}