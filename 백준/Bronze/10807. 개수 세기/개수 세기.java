import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int len = 0;
    static int count = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];   //0~100 사이 정수 개수를 저장할 배열 생성
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){  //각 정수 개수를 계산
            arr[len++] = Integer.parseInt(st.nextToken());
        }
        int V = Integer.parseInt(br.readLine());
        for(int i : arr){
            if(i == V) count++;
        }
        bw.write(Integer.toString(count));
        bw.flush();
        bw.close();
    }
}
