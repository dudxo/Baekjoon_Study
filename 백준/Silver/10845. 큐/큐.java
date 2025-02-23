import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static Deque<Integer> dq = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer str;

        N = Integer.parseInt(br.readLine());

        while(N-- > 0) {
            str = new StringTokenizer(br.readLine());
            switch(str.nextToken()) {
                case "push":
                    dq.add(Integer.parseInt(str.nextToken()));
                    break;
                case "pop":
                    if(dq.isEmpty()) {
                        sb.append("-1\n");
                        break;
                    }
                    sb.append(dq.removeFirst()).append("\n");
                    break;
                case "front":
                    if(dq.isEmpty()) {
                        sb.append("-1\n");
                        break;
                    }
                    sb.append(dq.peekFirst()).append("\n");
                    break;
                case "back":
                    if(dq.isEmpty()) {
                        sb.append("-1\n");
                        break;
                    }
                    sb.append(dq.peekLast()).append("\n");
                    break;
                case "size":
                    sb.append(dq.size()).append("\n");
                    break;
                case "empty":
                    if(dq.isEmpty()) {
                        sb.append("1\n");
                        break;
                    }
                    sb.append("0\n");
                    break;
            }
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }


}