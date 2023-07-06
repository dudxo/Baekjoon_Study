import java.io.*;

class Node<T> {
    Node<T> next = null;
    T data = null;
}

class Stack<T> {
    Node<T> head = null;

    public boolean isempty() {
        return head == null;
    }

    public void push(T data) {
        Node<T> newNode = new Node<>();
        newNode.data = data;

        if (!isempty()) {
            newNode.next = this.head;
        }
        this.head = newNode;
    }

    public T pop() {
        T tmp = this.head.data;
        Node<T> popedNode = this.head;
        this.head = this.head.next;

        popedNode.next = null;
        popedNode.data = null;
        return tmp;
    }

    public int size() {
        int size = 0;
        while (!isempty()) {
            pop();
            size++;
        }
        return size;
    }

    public int top() {
        if (isempty()) {
            return -1;
        }
        return (int) this.head.data;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        String cmd = "";
        int data = 0;

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            cmd = br.readLine();
            if (cmd.contains("push")) {
                data = Integer.parseInt(cmd.substring(5));
                cmd = cmd.substring(0, 4);
            }
            switch (cmd) {
                case "push":
                    stack.push(data);
                    break;
                case "pop":
                    if (!stack.isempty()) {
                        bw.write(Integer.toString(stack.pop()));
                    } else {
                        bw.write("-1");
                    }

                    break;
                case "size":
                    bw.write(Integer.toString(stack.size()));
                    break;
                case "empty":
                    if (stack.isempty()) {
                        bw.write("1");
                    } else {
                        bw.write("0");
                    }
                    break;
                case "top":
                    bw.write(Integer.toString(stack.top()));
            }
            bw.flush();
        }
    }
}