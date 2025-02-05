
import java.io.*;
import java.util.*;

public class Main {

    static int N, M, st, ed;
    static boolean[] switches;
    static Node[] persons;

    public static class Node {
        int sex;
        int num;

        Node(int sex, int num) {
            this.sex = sex;
            this.num = num;
        }

        private boolean checkMan() {
            return this.sex == 1;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        switches = new boolean[N+1];
        StringTokenizer str = new StringTokenizer(br.readLine());

        for(int i = 1; i <= N; i++) {
            if(Integer.parseInt(str.nextToken()) == 1) {
                switches[i] = true;
            }
        }

        M = Integer.parseInt(br.readLine());
        persons = new Node[M];

        for(int i = 0; i < M; i++) {
            str = new StringTokenizer(br.readLine());
            int sex = Integer.parseInt(str.nextToken());
            int num = Integer.parseInt(str.nextToken());
            persons[i] = new Node(sex, num);
        }

        for(Node person : persons) {
            if(person.checkMan()) {
                manSwitching(person.num);
                continue;
            }

            womanSwitching(person.num);
        }

        bw.write(print());
        bw.flush();
        br.close();
        bw.close();

    }

    private static void manSwitching(int num) {
        for(int i = num; i <= N; i += num) {
            reverseSwitch(i);
        }
    }

    private static void womanSwitching(int num) {
        reverseSwitch(num);

        if(num == 1 || num == N || switches[num-1] != switches[num+1]) {
            return;
        }

        twoPointer(num);
    }

    private static void twoPointer(int num) {
        st = num-1;
        ed = num+1;

        while(st >= 1 && ed <= N && isSymmetry(st, ed)) {
            reverseSwitch(st, ed);
            st -= 1;
            ed += 1;
        }
    }

    private static boolean isSymmetry(int st, int ed) {
        return switches[st] == switches[ed];
    }

    private static void reverseSwitch(int... index) {
        for(int i : index) {
            switches[i] = !switches[i];
        }
    }

    private static String print() {
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= N; i++) {
            sb.append(switches[i] ? "1" : "0").append(" ");
            if(i % 20 == 0) {
                sb.append("\n");
            }
        }

        return sb.toString();
    }

}