import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int sum = 1, count = 0;
    static StringTokenizer str;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        str = new StringTokenizer(br.readLine());
        br.close();

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(str.nextToken());
        }


        //순서는 상관없음
        //즉, 계산하기 쉽게 오름차순으로 정렬하기
        Arrays.sort(arr);

        int start_index = 0;
        int end_index = N - 1;

        //각 포인터가 만나기 전까지 반복
        while(start_index < end_index){
            sum = arr[start_index] + arr[end_index];
            if(sum == M){       //합이 N과 같을 때
                count++;
                start_index++;
                end_index--;
            } else if(sum > M){     //합이 N보다 클 때
                end_index--;        //오름차순 정렬 된 배열이니 큰 값을 가지는 end_index를 줄이기
            } else {        //합이 N보다 작을 때
                start_index++;      //마찬가지로 정렬 배열이니 작은 값을 가르키는 start_index를 이동
            }
        }


        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}