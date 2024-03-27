import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        arr = new int[Integer.parseInt(st.nextToken())];
        int X = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int a = 0; a < arr.length; a++){
            arr[a] = Integer.parseInt(st.nextToken());
        }

        for(int i : arr){
            if(X > i)
                bw.write(i + " ");
        }
        bw.flush();
        bw.close();
    }
}
