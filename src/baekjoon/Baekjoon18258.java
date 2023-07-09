package baekjoon;

import java.io.*;

/*class Node<T> {
    Node<T> next = null;
    T data = null;
}*/

class ListQueue<T> {
    Node<T> front = null;
    Node<T> rear = null;

    public void push(String data) {      // 시간복잡도 O(1)
        Node<T> newNode = new Node<>();
        newNode.data = (T) data;

        if (isEmtpy()) {
            front = newNode;
        } else {
            rear.next = newNode;
        }
        rear = newNode;
    }

    public String pop() {      // 시간복잡도 O(1)
        if (isEmtpy()) {
            return "-1";
        }

        T popeddata = front.data;

        if (front == rear) {
            front = null;
            rear = null;
        } else {
            front = front.next;
        }
        return (String) popeddata;
    }

    public String size() {      // 시간복잡도 O(1)
        int count = 1;

        Node<T> searchNode = front;

        if (isEmtpy()) {
            return "0";
        }
        while (searchNode.next != null) {
            searchNode = searchNode.next;
            count++;
        }

        return Integer.toString(count);
    }

    public boolean isEmtpy() {      // 시간복잡도 O(1)
        return front == null;
    }


    public String front() {      // 시간복잡도 O(1)
        if (isEmtpy()) {
            return "-1";
        }
        return (String) front.data;
    }

    public String back() {      // 시간복잡도 O(1)
        if (isEmtpy()) {
            return "-1";
        }
        return (String) rear.data;
    }
}

public class Baekjoon18258 {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static ListQueue<String> listQueue = new ListQueue<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = 0;
        String cmd = "";
        T = Integer.parseInt(br.readLine());


        while (T-- > 0) {
            cmd = br.readLine();
            sol(cmd);
        }
        bw.close();
    }

    public static void sol(String cmd) throws IOException {
        switch (cmd) {
            case "pop":
                bw.write(listQueue.pop() + "\n");
                break;
            case "size":
                bw.write(listQueue.size() +"\n");
                break;
            case "empty":
                bw.write(listQueue.isEmtpy() ? "1" : "0" + "\n");
                break;
            case "front":
                bw.write(listQueue.front() + "\n");
                break;
            case "back":
                bw.write(listQueue.back() + "\n");
                break;
            default:
                listQueue.push(cmd.substring(5));
        }
        bw.flush();
    }
}