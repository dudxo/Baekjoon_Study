import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static Node[] trees;

    //전위 순회
    public static void preorder(Node node) {
        if(node == null) return;
        System.out.print(node.data);
        preorder(node.left);
        preorder(node.right);
    }

    //중위 순회
    public static void inorder(Node node) {
        if(node == null) return;
        inorder(node.left);
        System.out.print(node.data);
        inorder(node.right);
    }

    //후위 순회
    public static void postorder(Node node) {
        if(node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        trees = new Node[N + 1];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            char parent = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            if (trees[parent - 'A'] == null) {
                trees[parent - 'A'] = new Node(parent);
            }
            if (left != '.') {
                trees[left - 'A'] = new Node(left);
                trees[parent - 'A'].left = trees[left - 'A'];
            }
            if (right!= '.') {
                trees[right - 'A'] = new Node(right);
                trees[parent - 'A'].right = trees[right - 'A'];
            }
        }

        preorder(trees[0]);
        System.out.println();

        inorder(trees[0]);
        System.out.println();

        postorder(trees[0]);
        System.out.println();
    }


    static class Node {
        Object data;
        Node left;
        Node right;

        public Node() {

        }

        public Node(Object data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public void addLeft(Node left) {
            this.left = left;
        }

        public void addRight(Node Right) {
            this.right = right;
        }
    }
}
