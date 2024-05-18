import java.io.*;
import java.util.StringTokenizer;

public class Main {
    
    static int sum = 1, count = 1, start_index = 1, end_index = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        br.close();

        while(end_index != N){
            if(sum == N){   //현재 합이 N과 같을 때
                count++;
                end_index++;
                sum = sum + end_index;
            } else if(sum > N){     //현재 합이 N보다 클 때
                sum = sum - start_index;
                start_index++;
            } else{     //현재 합이 N보다 작을 때
                end_index++;
                sum = sum + end_index;
            }
        }
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}