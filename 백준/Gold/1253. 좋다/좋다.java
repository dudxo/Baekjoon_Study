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
        int[] arr = new int[N];

        str = new StringTokenizer(br.readLine());
        br.close();

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(str.nextToken());
        }


        //순서는 상관없음
        //즉, 계산하기 쉽게 오름차순으로 정렬하기
        Arrays.sort(arr);

        for(int k = 0; k < N; k++){
            long find = arr[k];     //좋은 수
            int start_index = 0;
            int end_index = N - 1;
            while(start_index < end_index){     //두 값의 합이여야 되기 때문에 둘이 만나기 전까지만 반복
                sum = arr[start_index] + arr[end_index];
                if(sum == find){        //합이 같으면 좋은 수
                    if(start_index != k && end_index != k) {        //서로 다른 두 수인지 체크
                        count++;
                        break;      //프로세스 종료
                    } else if (start_index == k) {
                        start_index++;
                    } else if (end_index == k){
                        end_index--;
                    }
                } else if(sum > find){      //합이 기준 값보다 클 때
                    end_index--;
                } else{     //합이 기준 값보다 작을 때
                    start_index++;
                }
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}