package Algorithm.Tree;

public class Tree {
    int level;      // 트리 레벨

    public Tree() {     // 트리 생성자
        level = 0;      // 맨 처음 루트 노드는 존재하니 트리 레벨 0으로 초기화
    }

    public class Node{      // 트리를 구현하기 위한 노드
        Object data;        // data
        Node left;          // 왼쪽 자식 노드
        Node right;         // 오른쪽 자식 노드

        public Node(Object data) {      // data 파라미터가 있는 노드 생성자
            this.data = data;
            left = null;
            right = null;
        }

        public void addLeft(Node left) {        // 왼쪽 자식 노드 추가
            this.left = left;       // 부모 노드 왼쪽에 자식 노드를 추가하고

            if (this.right == null) {       // 오른쪽이 비어있다면
                level++;                    // 새로 한 단계 추가 되었으니 레벨 증가
            }
        }

        public void addRight(Node right) {      // 오른쪽 자식 노드 추가
            this.right = right;     // 부모 노드 오른쪽에 자식 노드를 추가하고

            if (this.left == null) {        // 왼쪽이 비어있다면
                level++;                    // 새로 한 단계 추가 되었으니 레벨 증가
            }
        }

        public void deleteLeft() {      // 왼족 자식 노드 삭제
            this.left = null;       // 왼쪽 노드 null로 초기화, 참조되지 않는 노드는 자동 삭제

            if (this.right == null) {       // 오른쪽이 없다면
                level--;                    // 한 단계 감소 되었으니 레벨 감소
            }
        }

        public void deleteRight() {     // 오른쪽 자식 노드 삭제
            this.right = null;

            if (this.left == null) {        // 왼쪽이 없다면
                level--;                    // 한 단계 감소 되었으니 레벨 감소
            }
        }
    }

    public Node addNode(Object data) {      // 노드 만드는 연산
        Node n = new Node(data);
        return n;
    }

    public void preOrder(Node node) {       // 전위 순회
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder(Node node) {        // 중위 순회
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.data + " ");
        inOrder(node.right);
    }

    public void postOrder(Node node) {      // 후위 순회
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.data + " ");
    }
}
