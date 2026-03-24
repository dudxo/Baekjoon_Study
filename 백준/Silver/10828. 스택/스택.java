import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Stack<Integer> stack = new Stack<>();

		int N = Integer.parseInt(br.readLine());
		String cmd;


		while (N-- > 0) {
			cmd = br.readLine();

			if(cmd.startsWith("push")) {
				String[] arr = cmd.split(" ");
				stack.push(Integer.parseInt(arr[1]));
				continue;
			}

			switch (cmd) {
				case "pop":
					bw.write(stack.pop() + "\n");
					break;
				case "empty":
					bw.write(stack.empty() + "\n");
					break;
				case "size":
					bw.write(stack.size() + "\n");
					break;
				case "top":
					bw.write(stack.top() + "\n");
					break;
			}
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
	Node<T> head = null;

	int top = -1;

	public int empty() {
		if(head == null) return 1;
		return 0;
	}

	public void push(T data) {
		Node<T> newNode = new Node<>();
		newNode.data = data;

		if(empty() == 0) {
			newNode.next = this.head;
		}
		this.head = newNode;
		top++;
	}

	public int pop() {
		if(empty() == 1) {
			return -1;
		}

		T tmp = this.head.data;
		Node<T> nextNode = this.head;
		this.head = nextNode.next;

		nextNode.next = null;
		nextNode.data = null;
		top--;
		return (int) tmp;
	}

	public int size() {
		return top + 1;
	}

	public int top() {
		if(empty() == 1) {
			return -1;
		}

		return (int) this.head.data;
	}
}