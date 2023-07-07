package baekjoon;

import java.io.*;

class Node<T> {     // T타입 노드
    Node<T> next = null;        // 다음 노드를 지정할 next null 초기화
    T data = null;      // 노드의 data null 초기화
}

class Stack<T> {
    Node<T> head = null;        // head(항상 마지막 Node를 가르킴) null 초기화

    int top = -1;       // top -1 초기화
    public boolean isempty() {      // Stack 공백 체크  * 시간복잡도 : O(1)
        return head == null;
    }

    public void push(T data) {      // data push 연산  * 시간복잡도 : O(1)
        Node<T> newNode = new Node<>();     // newNode 생성
        newNode.data = data;        // newNode의 push할 data 대입

        if (!isempty()) {       // 공백이 아닌 즉 이미 다른 Node가 있다면
            newNode.next = this.head;       // head가 가르키는 주소 즉 맨 마지막 Node를 newNode가 가르키도록 대입
        }
        this.head = newNode;        // head는 newNode를 참조
        top++;      // top 증가
    }

    public int pop() {      // data pop 연산  * 시간복잡도 : O(1)
        if (isempty()) {        // 공백이라면 return -1
            return -1;
        }
        T tmp = this.head.data;     // 꺼내올 top data를 임시 변수 T의 저장
        Node<T> popedNode = this.head;      // 삭제될 노드(head가 가르키는 곳)를 popeNode로 지정
        this.head = this.head.next;     // head는 삭제될 노드의 다음 노드를 가르킴

        popedNode.next = null;      // 삭제될 노드의 next(다음 노드 값) null 대입
        popedNode.data = null;      // 삭제될 노드의 data(노드 data) null 대입해 삭제
        top--;      // top 감소
        return (int) tmp;       // 삭제 될 data(pop연산 전 top data) return

    }

    public int size() {     // size == Stack 크기  * 시간복잡도 : O(1)
        return top+1;       // Stack의 크기 return
    }

    public int top() {      // top data return  * remove X  * 시간복잡도 : O(1)
        if (isempty()) {        // 공백이라면 return -1
            return -1;
        }
        return (int) this.head.data;        // top data return
    }
}

/**
 * 총 시간 복잡도
 * while : O(N)
 * stack : O(1)
 * = O(N)..?
 */
public class Baekjoon10828 {

    static Stack<Integer> stack = new Stack<>();        // sol()메소드에서도 사용하기 때문에 전역 변수 지정
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());        // 명령의 수

        String cmd = "";        // 명령어가 담길 지역변수 cmd

        while (N-- > 0) {       // 명령의 수만큼 반복
            cmd = br.readLine();        // 명령어 입력
            sol(cmd);       // 명령 수행
        }
    }

    /**
     *  명령어를 해석해 Stack 메소드 실행
     */
    public static void sol(String cmd) throws IOException {

        int data = 0;      // push 될 지역변수 data

        if (cmd.contains("push")) {     // push 명령어 분리 로직
            data = Integer.parseInt(cmd.substring(5));      // push 뒤 data 값 추출
            cmd = cmd.substring(0, 4);      // 명령어에 push만 남김
        }
        switch (cmd) {      // 해당 명령어 실행 로직
            case "push":
                stack.push(data);
                break;
            case "pop":
                bw.write(Integer.toString(stack.pop()));
                bw.newLine();       // 한 줄에 하나씩 출력하기 위해 newLine() 사용
                break;
            case "size":
                bw.write(Integer.toString(stack.size()));
                bw.newLine();
                break;
            case "empty":
                if (stack.isempty()) {
                    bw.write("1");
                } else {
                    bw.write("0");
                }
                bw.newLine();
                break;
            case "top":
                bw.write(Integer.toString(stack.top()));
                bw.newLine();
                break;
        }
        bw.flush();
    }
}