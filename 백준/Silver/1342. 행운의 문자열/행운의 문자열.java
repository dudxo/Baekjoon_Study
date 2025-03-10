import java.io.*;
import java.util.*;

public class Main {

    static char[] arr, arr2;
    static boolean[] isUsed;
    static HashSet<String> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        arr = br.readLine().toCharArray();
        isUsed = new boolean[arr.length];
        arr2 = new char[arr.length];
        set = new HashSet<>();

        sol(0);

        bw.write(String.valueOf(set.size()));
        bw.flush();
        br.close();
        bw.close();
    }

    private static void sol(int k) {
        if(k == arr.length && check()) {
            StringBuilder sb = new StringBuilder();
            for(char c :  arr2) {
                sb.append(c);
            }
            set.add(sb.toString());
            return;
        }

        for(int i = 0; i < arr.length; i++) {
            if(!isUsed[i]) {
                arr2[k] = arr[i];
                isUsed[i] = true;
                sol(k+1);
                isUsed[i] = false;
            }
        }
    }

    private static boolean check() {
        for(int i = 0; i < arr2.length-1; i++) {
            if(arr2[i] == arr2[i+1]) {
                return false;
            }
        }
        return true;
    }

}
