import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int[] count = new int[26];
        str = str.toUpperCase();
        int tmp = 0;
        char result = ' ';
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i) - 'A']++;
        }
        for (int k = 0; k < count.length; k++) {
            if (tmp < count[k]) {
                tmp = count[k];
                result = (char) ('A' + k);
            }
            else if (tmp == count[k]) {
                tmp = count[k];
                result = '?';
            }
        }
        System.out.print(result);
    }
}