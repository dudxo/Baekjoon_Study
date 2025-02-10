import java.io.*;
import java.util.*;

public class Main {

    static int L, C;
    static char[] answer, arr;
    static boolean[] isUsed;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer str = new StringTokenizer(br.readLine());
        L = Integer.parseInt(str.nextToken());
        C = Integer.parseInt(str.nextToken());

        arr = new char[C+1];
        isUsed = new boolean[C+1];
        answer = new char[L];

        str = new StringTokenizer(br.readLine());
        for(int i = 1; i <= C; i++) {
            arr[i] = str.nextToken().charAt(0);
        }

        Arrays.sort(arr);

        backTracking(0, sb);

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    private static void backTracking(int k, StringBuilder sb) {
        if(k == L) {
            if(checkVowel(answer) && checkConsonant(answer)) {
                for (char c : answer) {
                    sb.append(c);
                }
                sb.append("\n");
            }
            return;
        }

        for(int i = 1; i <= C; i++) {
            if(!isUsed[i]) {
                if(k >= 1 && answer[k-1] > arr[i]) {
                    continue;
                }
                answer[k] = arr[i];
                isUsed[i] = true;
                backTracking(k+1, sb);
                isUsed[i] = false;
            }
        }
    }

    private static boolean checkConsonant(char[] answer) {
        int count = 0;
        for(char c : answer) {
            if(c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u') {
                count += 1;
            }
            if(count == 2) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkVowel(char[] answer) {
        for(char c : answer) {
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                return true;
            }
        }
        return false;
    }
}