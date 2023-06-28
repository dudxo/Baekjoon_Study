import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();

        pikachu2(S);

    }

    static void pikachu2(String S) {
        int S_size = S.length();
        boolean flag = true;
        for (int i = 0; i <= S_size - 2;) {
            if (i < S_size-1 && S.charAt(i) == 'p') {
                if (!S.substring(i, i+2).equals("pi")) {
                    flag = false;
                    break;
                }
                i += 2;
            } else if (i < S_size-1 && S.charAt(i) == 'k') {
                if (!S.substring(i, i + 2).equals("ka")) {
                    flag = false;
                    break;
                }
                i += 2;
            } else if (i < S_size-2 && S.charAt(i) == 'c') {
                if (!S.substring(i, i + 3).equals("chu")) {
                    flag = false;
                    break;
                }
                i += 3;
            } else {
                flag = false; break;
            }
        }

        if (flag == true) {
            System.out.print("YES");
        } else {
            System.out.print("NO");
        }
    }

/*    static void pikachu(String S) {
        int S_size = S.length();
        boolean flag = true;
        for (int i = 0; i < S_size;) {
            if (i<=S_size-1 && S.charAt(i) == 'p') {
                if (S.charAt(i + 1) != 'i') {
                    flag = false;
                    break;
                }
                i += 2;
            } else if (i <=S_size-1 && S.charAt(i) == 'k') {
                if (S.charAt(i + 1) != 'a') {
                    flag = false;
                    break;
                }
                i +=2;
            } else if (i <= S_size-2 && S.charAt(i) == 'c') {
                if (S.charAt(i + 1) != 'h') {
                    flag = false;
                    break;
                } else if (S.charAt(i + 2) != 'u') {
                    flag = false;
                    break;
                }
                i += 3;
            } else {
                flag = false;
                break;
            }
        }

        if (flag == true) {
            System.out.print("YES");
        } else {
            System.out.print("NO");
        }
    }*/
}