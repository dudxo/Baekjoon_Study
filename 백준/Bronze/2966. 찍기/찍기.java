import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static char[] s, c, h, answer;
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        s = new char[] {'A', 'B', 'C'};
        c = new char[] {'B', 'A', 'B', 'C'};
        h = new char[] {'C', 'C', 'A', 'A', 'B', 'B'};
        N = sc.nextInt();
        answer = sc.next().toCharArray();

        int Adrian = grade(s);
        int Bruno = grade(c);
        int Goran = grade(h);

        int max = Math.max(Adrian, Math.max(Bruno, Goran));
        StringBuilder sb = new StringBuilder();
        sb.append(max).append("\n");

        if(max == Adrian) {
            sb.append("Adrian").append("\n");
        }
        if(max == Bruno) {
            sb.append("Bruno").append("\n");
        }
        if(max == Goran) {
            sb.append("Goran").append("\n");
        }

        System.out.println(sb);
    }

    private static int grade(char[] man) {
        int count = 0;
        Queue<Character> q = new LinkedList<>();

        for(char c : man) {
            q.add(c);
        }

        for(int i = 0; i < N; i++) {
            char c = q.poll();
            if(answer[i] == c) {
                count++;
            }
            q.add(c);
        }

        return count;
    }
}