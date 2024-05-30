import java.io.*;

public class Main {

    static int[] arr;
    static int index = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] ch = br.readLine().toCharArray();
        arr = new int[ch.length];

        //정렬할 수
        for(int i = 0; i < ch.length; i++){
            arr[i] = Integer.parseInt(String.valueOf(ch[i]));
        }

        ///선택 정렬
        for(int i = 0; i < arr.length; i++){
            int max = arr[i];       //남은 정렬 부분 중 가장 앞에 있는 값
            for(int j = i + 1; j < arr.length; j++){
                //남은 정렬 부분 중에서 최댓값 찾기 
                if(max < arr[j]){
                    max = arr[j];
                    index = j;
                }
            }
            //남은 정렬 부분 중 가장 앞에 있는 값이 최대값이 아니라면
            //찾은 최대값과 swap
            if(max != arr[i]) {
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i : arr){
            sb.append(i);
        }
        System.out.println(sb);
    }

}