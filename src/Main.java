import java.io.*;

public class Main {
    public static int[] getCount(String s) {
        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bw = new BufferedReader(new InputStreamReader(System.in));

        String a = bw.readLine();
        String b = bw.readLine();

        int[] a1 = getCount(a);
        int[] b1 = getCount(b);

        int ans = 0;
        for (int k = 0; k < 26; k++) {
            ans += Math.abs(a1[k] - b1[k]);
        }

        System.out.println(ans);
    }
}