import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String parent = br.readLine();
        String pattern = br.readLine();

        kmp(parent, pattern);
    }

    static int[] table(String pattern) {
        char[] patterns = pattern.toCharArray();
        int[] table = new int[patterns.length];
        int k = 0;

        for (int i = 1; i < patterns.length; i++) {
            while (k > 0 && patterns[i] != patterns[k]) {
                k = table[k - 1];
            }
            if (patterns[i] == patterns[k]) {
                table[i] = ++k;
            }
        }

        return table;
    }

    static void kmp(String parent, String pattern) {
        char[] parents = parent.toCharArray();
        char[] patterns = pattern.toCharArray();
        int[] makeTable = table(pattern);

        StringBuilder sb = new StringBuilder();

        int k = 0, check = 0;

        for (int i = 0; i < parents.length; i++) {
            while (k > 0 && parents[i] != patterns[k]) {
                k = makeTable[k - 1];
            }
            if (parents[i] == patterns[k]) {
                if (k == patterns.length - 1) {
                    k = makeTable[k];
                    check = 1;
                } else {
                    k++;
                }
            }
        }
        System.out.print(check);
    }
}