import java.io.*;
import java.util.*;

public class Main {

    static int[] arr;
    static boolean result = true;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N  = Integer.parseInt(br.readLine());
        arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Stack<Integer> st = new Stack<>();
        int num = 1;
        for(int i = 0; i < N; i++){
            int su = arr[i];
            if(su >= num){
                while(su >= num){
                    st.push(num++);
                    sb.append("+").append("\n");
                }
                st.pop();
                sb.append("-").append("\n");
            } else{
                int n = st.pop();
                if(n > su){
                    result = false;
                    System.out.println("NO");
                    break;
                } else{
                    sb.append("-").append("\n");
                }
            }
        }
        if(result) {
            System.out.println(sb);
        }
    }

}