import java.io.*;
import java.util.*;
public class Main {

    static int k;
    static int[] arr, nums;
    static char[] chars;
    static boolean[] isUsed;
    static List<String> answers;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        init();
        StringTokenizer str = new StringTokenizer(br.readLine());

        k = Integer.parseInt(str.nextToken());
        arr = new int[k+1];
        chars = new char[k];

        str = new StringTokenizer(br.readLine());
        for(int i = 0; i < k; i++) {
            chars[i] = str.nextToken().charAt(0);
        }

        backTracking(0);


        StringBuilder sb = new StringBuilder();
        sb.append(answers.get(answers.size()-1)).append("\n").append(answers.get(0));

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    private static void backTracking(int m) {
        if(m == k+1) {
            String answer = "";
            for(int index : arr) {
                answer += String.valueOf(index);
            }
            answers.add(answer);
            return;
        }
        for(int i = 0; i < 10; i++) {
            if(!isUsed[i]) {
                if(m == 0) {
                    arr[m] = nums[i];
                    isUsed[i] = true;
                    backTracking(m+1);
                    isUsed[i] = false;
                }
                else {
                    if(chars[m-1] == '<') {
                        if(arr[m-1] < nums[i]) {
                            arr[m] = nums[i];
                            isUsed[i] = true;
                            backTracking(m+1);
                            isUsed[i] = false;
                        }
                    }
                    if(chars[m-1] == '>'){
                        if(arr[m-1] > nums[i]) {
                            arr[m] = nums[i];
                            isUsed[i] = true;
                            backTracking(m+1);
                            isUsed[i] = false;
                        }
                    }
                }
            }
        }
    }

    private static void init() {
        nums = new int[10];
        isUsed = new boolean[10];
        answers = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            nums[i] = i;
        }
    }

}