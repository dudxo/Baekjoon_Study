import java.util.Scanner;

public class Main {


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0; i < T; i++) {
            int score = 0;
            int jumsu = 1;
            char[] ch = sc.next().toCharArray();
            for (char c : ch) {
                if(c == 'O'){
                    score += jumsu;
                    jumsu++;
                } else{
                    jumsu = 1;
                }
            }
            System.out.println(score);
        }

    }
}


