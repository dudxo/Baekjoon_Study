import java.io.*;
import java.util.*;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		String cmd = "";

		Stack<Integer> stack = new Stack<>();

		while(N-- > 0) {
			cmd = br.readLine();

			if(cmd.contains("push")) {
				String[] arr = cmd.split(" ");
				stack.push(Integer.parseInt(arr[1]));
				continue;
			}

			switch (cmd) {
				case "pop":
					bw.write(String.valueOf(stack.pop()));
					break;
				case "size":
					bw.write(String.valueOf(stack.size()));
					break;
				case "empty":
					bw.write(String.valueOf(stack.empty()));
					break;
				case "top":
					bw.write(String.valueOf(stack.top()));
					break;
			}
			bw.newLine();
		}

		bw.flush();
		bw.close();
	}

}

class Node<T> {
	Node<T> next = null;
	T data = null;
}

class Stack<T> {
	Node<T> root = null;

	int top = -1;

	public void push(T data) {
		Node node = new Node();
		node.data = data;

		if(top != -1) {
			node.next = this.root;
		}
		this.root = node;
		top++;
	}

	public int pop() {
		if(top == -1) {
			return -1;
		}

		T data = this.root.data;
		Node next = this.root.next;
		root.data = null;
		root.next = null;
		this.root = next;
		top --;

		return (int) data;
	}

	public int size() {
		return top + 1;
	}

	public int empty() {
		if(top == -1) {
			return 1;
		}

		return 0;
	}

	public int top() {
		if(top == -1) return -1;

		return (int) this.root.data;
	}
}