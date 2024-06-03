import java.io.*;

public class Main {

    static int[] A;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        A = new int[N];
        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(br.readLine());
        }
        br.close();
        Radix_Sort(A, 5);
        for(int i = 0; i < N; i++){
            bw.write(A[i] + "\n");
        }
        bw.flush();
        bw.close();
    }

    //구간 합을 이용한 기수 정렬
    public static void Radix_Sort(int[] A, int max_size){
        int[] output = new int[A.length];
        int jarisu = 1;
        int count = 0;
        while (count != max_size){      //최대 자리수만큼 반복하기
            int[] bucket = new int[10];
            for(int i = 0; i < A.length; i++){
                bucket[(A[i] / jarisu) % 10]++;     //일의 자리부터 시작
            }
            for(int i = 1; i < 10; i ++){
                bucket[i] += bucket[i-1];       //합 배열을 이용해 index 계산하기
            }
            for(int i = A.length - 1; i >= 0; i--){     //현재 자릿수를 기준으로 정렬하기
                output[bucket[(A[i] / jarisu % 10)] - 1] = A[i];
                bucket[(A[i] / jarisu) % 10]--;
            }
            for(int i = 0; i < A.length; i++){
                A[i] = output[i];
            }
            jarisu = jarisu * 10;
            count++;
        }
    }

}