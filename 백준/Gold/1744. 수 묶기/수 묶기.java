import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Integer> positive = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> negative = new PriorityQueue<>();

        int num = 0;
        int one = 0;
        int zero = 0;

        for(int i = 0; i < N; i ++) {
            num = sc.nextInt();
            if(num > 1) {
                positive.add(num);
            } else if (num == 0) {
                zero++;
            } else if (num == 1) {
                one++;
            } else {
                negative.add(num);
            }
        }

        int sum = 0;
        int data1 = 0;
        int data2 = 0;


        while(positive.size() > 1) {
            data1 = positive.remove();
            data2 = positive.remove();
            sum += data1 * data2;
        }
        if(!positive.isEmpty()) {
            sum += positive.remove();
        }

        while(negative.size() > 1) {
            data1 = negative.remove();
            data2 = negative.remove();
            sum += data1 * data2;
        }
        if(!negative.isEmpty()) {
            // 최대값을 구하기 위해 0이 있다면 남은 음수(가장 큰 음수)를 곱한다.
            // 이러면 결국 0이기 때문에 sum을 하지않는다.
            // 0이 없다면 어쩔 수 없이 남은 음수를 총 합에 더하여 계산한다.
            if(zero == 0) {
                sum += negative.remove();
            }
        }
        sum += one;

        System.out.println(sum);
    }

}
