import java.util.Arrays;
import java.util.Scanner;

public class Main {


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] alpa = new int[26];
        boolean[] check = new boolean[26];

        for(int i = 0; i < 26; i++) {
            alpa[i] = -1;
            check[i] = false;
        }

        char[] ch = sc.nextLine().toCharArray();

        for(int i = 0; i < ch.length; i++) {
            int index = ch[i] - 97;
            if(!check[index]) {
                alpa[index] = i;
                check[index] = true;
            }
        }
        Arrays.stream(alpa).forEach(i -> System.out.print(i + " "));

    }
}


