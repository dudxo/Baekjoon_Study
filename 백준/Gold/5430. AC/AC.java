import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {

    static char[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            Deque<Integer> deque = new LinkedList<>();
            String p = br.readLine();   // 명령어
            String n = br.readLine();

            String str = br.readLine();
            arr = new char[str.length()];

            for (String s : str.substring(1, str.length() - 1).split(",")) {
                if (!s.equals("")) {
                    deque.add(Integer.valueOf(s));
                }
            }
            System.out.println(command(p, deque));

        }

    }

    static String command(String p, Deque<Integer> deque) {
        //check가 true라면 앞에서
        //check가 false라면 뒤에서
        boolean check = true;

        for(int i = 0; i < p.length(); i++){
            char c = p.charAt(i);
            switch (c) {
                case 'R':
                    check = !check;
                    break;
                case 'D':
                    if(deque.size() == 0){
                        return "error";
                    }

                    if (!check) {
                        deque.removeLast();
                    } else {
                        deque.removeFirst();
                    }
                    break;
            }
        }
        StringBuilder sb = new StringBuilder("[");
        if (check) {
            while (!deque.isEmpty()){
                sb.append(deque.removeFirst());
                if(!deque.isEmpty()) {
                    sb.append(",");
                }
            }
            sb.append("]");
        } else {
            while (!deque.isEmpty()){
                sb.append(deque.removeLast());
                if(!deque.isEmpty()) {
                    sb.append(",");
                }
            }
            sb.append("]");
        }
        return sb.toString();
    }
}
