import java.io.*;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Integer> cards = new PriorityQueue<>();
        for(int i = 0; i < N; i++) {
            cards.add(sc.nextInt());
        }

        int pareCount = 0;
        int card1 = 0;
        int card2 = 0;

        while(cards.size() != 1) {
            card1 = cards.remove();
            card2 = cards.remove();
            pareCount += card1 + card2;
            cards.add(card1 + card2);
        }
        System.out.println(pareCount);
    }

}
