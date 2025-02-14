import java.io.*;
import java.util.*;


public class Main {

    static int N;
    static Node[] trees;
    public static class Node {
        char key;
        Node root;
        Node left;
        Node right;

        Node(){}

        Node(char key, Node root) {
            this.key = key;
            this.root = root;
            this.left = null;
            this.right = null;
        }

        public void addLeft(Node left) {
            this.left = left;
        }

        public void addRight(Node right) {
            this.right = right;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer str;

        N = Integer.parseInt(br.readLine());
        trees = new Node[N];

        for(int i = 0; i < N; i++) {
            str = new StringTokenizer(br.readLine());
            char p = str.nextToken().charAt(0);
            char lc = str.nextToken().charAt(0);
            char rc = str.nextToken().charAt(0);

            Node parents = new Node(p, null);
            trees[p - 'A'] = parents;
            if('.' != lc) {
                Node leftChild = new Node(lc, parents);
                parents.addLeft(leftChild);
                trees[lc - 'A'] = parents;
            }
            if('.' != rc) {
                Node rightChild = new Node(rc, parents);
                parents.addRight(rightChild);
                trees[rc - 'A'] = parents;
            }
        }

        solve(sb);

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    private static void solve(StringBuilder sb) {
        preOrder(sb, trees[0].key);
        sb.append("\n");
        inOrder(sb, trees[0].key);
        sb.append("\n");
        postOrder(sb, trees[0].key);
    }

    // 전위 순회(부모 -> 왼 -> 오)
    private static void preOrder(StringBuilder sb, char key) {
        Node now = trees[key - 'A'];

        sb.append(now.key);
        if(now.left != null) {
            preOrder(sb, now.left.key);
        }
        if(now.right != null) {
            preOrder(sb, now.right.key);
        }
    }

    // 중위 순회(왼 -> 부모 -> 오)
    private static void inOrder(StringBuilder sb, char key) {
        Node now = trees[key - 'A'];

        if(now.left != null) {
            inOrder(sb, now.left.key);
        }
        sb.append(now.key);
        if(now.right != null) {
            inOrder(sb, now.right.key);
        }
    }

    // 후위 순회(왼 -> 오 -> 부모)
    private static void postOrder(StringBuilder sb, char key) {
        Node now = trees[key - 'A'];

        if(now.left != null) {
            postOrder(sb, now.left.key);
        }
        if(now.right != null) {
            postOrder(sb, now.right.key);
        }
        sb.append(now.key);
    }


}