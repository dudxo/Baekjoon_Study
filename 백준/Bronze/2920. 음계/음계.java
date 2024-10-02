import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static int[] asc, des, num;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        asc = new int[] {1,2,3,4,5,6,7,8};
        des = new int[] {8,7,6,5,4,3,2,1};
        num = new int[8];
        for(int i = 0; i < 8; i++) {
            num[i] = sc.nextInt();
        }

        if(Arrays.equals(asc, num)) {
            System.out.println("ascending");
        } else if (Arrays.equals(des, num)) {
            System.out.println("descending");
        } else {
            System.out.println("mixed");
        }

    }
}


