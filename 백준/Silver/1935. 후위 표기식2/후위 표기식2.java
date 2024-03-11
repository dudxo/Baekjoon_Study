import java.io.*;
import java.util.*;

public class Main {
    static int[] num;   //피연산자의 값을 집어넣을 정수형 정적 배열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());    //피연산자 개수 입력
        String st = br.readLine();      //후위 표기식 입력
        Stack<String> stack = new Stack<>();

        num = new int[n];   //피연산자 개수만큼 정적 배열 초기화

        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(br.readLine());   //정적 배열에 대응되는 피연산자 값 넣기
        }
        for(int j = 0; j < st.length(); j++) {
            char ch = st.charAt(j);     //아스키코드 값 비교를 위한 문자열 파싱
            if (ch >= 'A' && ch <= 'Z') {       //후위 표기식의 문자가 피연산자라면 스택에 push
                stack.push(String.valueOf(ch));
            } else {    //후위 표기식의 문자가 연산자라면
                double op1 = calculate(stack.pop());    //스택에 있는 문자 2개를 꺼낸다.
                double op2 = calculate(stack.pop());
                switch (ch) {
                    //연산자에 맞게 연산 진행 후 다시 스택에 push
                    //단, 연산 시 주의 해야될 점으로 뒤늦게 꺼내진 피연산자의 값이 앞에 위치해야됨!
                    case '+' : stack.push(String.valueOf(op2 + op1)); break;
                    case '-' : stack.push(String.valueOf(op2 - op1)); break;
                    case '*' : stack.push(String.valueOf(op2 * op1)); break;
                    case '/' : stack.push(String.valueOf(op2 / op1)); break;
                }
            }
        }
        wr.write(String.format("%.2f", Double.parseDouble(stack.pop())));
        wr.flush();
        wr.close();

    }


    static double calculate(String op) {
        //피연산자가 계산된 값이라면 그대로 반환하고
        //계산되지 않은 문자라면 아스키코드로 변환한 뒤에, 정적 배열에 대응되는 피연산자 값을 찾아서 반환한다.
        char c = op.charAt(0);
        if (c >= 'A' && c <= 'Z') {
            return num[op.charAt(0) - 'A'];
        }
        return Double.parseDouble(op);
    }

}
