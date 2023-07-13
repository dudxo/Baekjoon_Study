package Algorithm.Tree;

class Node {
    Integer key = null;     // key
    Node left = null;       // 왼쪽 자식 노드
    Node right = null;      // 오른쪽 자식 노드
}

public class BinaryTree {
    Node root = null;       // root를 null로 초기화

    public void add(int key) {      // 노드 삽입
        Node newNode = new Node();      // newNode 생성
        newNode.key = key;              // newNode의 key 값 대입

        if (root == null) {     // root가 null이면 newNode는 root
            root = newNode;
        } else {        // root가 null이 아니면 자식 노드로 추가
            root = addNode(root, newNode);
        }
    }

    public Node addNode(Node node, Node newNode) {      // 크기를 비교해 부모 노드보다 작으면 왼쪽으로, 크면 오른쪽으로 추가
        if (node == null) {
            return newNode;
        } else if (node.key > newNode.key) {
            node.left = addNode(node.left, newNode);
        } else {
            node.right = addNode(node.right, newNode);
        }

        return node;
    }

    public void remove(int key) {       // 값 삭제
        root = removeNode(root, key);
    }

    private Node removeNode(Node node, int key) {               // 삭제하 노드가 중간에 있다면 값을 대체 해줘야됨. 그에 대한 연산
        if (node == null) {
            throw new RuntimeException("해당 값을 가진 노드를 찾을 수 없습니다.");
        }

        if (node.key > key) {           // 키의 값이 작으면 왼쪽으로 이동
            node.left = removeNode(node.left, key);
        }
        else if (node.key < key) {      // 키의 값이 크면 오른쪽으로 이동
            node.right = removeNode(node.right, key);
        }
        else {      // 삭제할 노드를 찾았을 때
            if (node.left != null) {        // 왼쪽 서브 트리에서 가장 큰 값을 찾아서 대체
                Node child = findMaxNode(node.left);        // 왼쪽에서 가장 큰 값을 대체할 노드 child에 넣고
                int removedKey = node.key;     // 삭제할 노드의 값은 removedKey에 저장
                node.key = child.key;       // 삭제될 위치(노드)에 왼쪽 서브 트리에서 가장 큰 값을 가진 노드 child로 대체
                child.key = removedKey;     // child는 삭제할 노드의 값을 가지고
                node.left = removeNode(node.left, key);     // 삭제할 노드의 자식이 없어질 때까지 반복
            } else if (node.right != null) {        // 오른쪽 서브 트리에서 가장 작은 값으 찾아서 대체
                Node child = findMinNode(node.right);
                int removedData = node.key;
                node.key = child.key;
                child.key = removedData;
                node.right = removeNode(node.right, key);
            } else {
                return null;        // 삭제할 노드가 자식을 가지고 있지 않을때(리프 노드) 종료
            }
        }
        return node;
    }

    private Node findMaxNode(Node node) {       // 가장 큰 값을 가진 노드 찾기
        if (node.right == null) {
            return node;
        } else {
            return findMaxNode(node.right);
        }
    }

    private Node findMinNode(Node node) {       // 가장 작은 값을 가진 노드 찾기
        if (node.left == null) {
            return node;
        } else {
            return findMinNode(node.left);
        }
    }

    public void search(int key) {       // 탐색
        searchNode(root, key);
    }

    private Node searchNode(Node node, int key) {       // 재귀 탐색
        if (node == null) {
            throw new RuntimeException("해당 값을 가진 노드를 찾을 수 없습니다.");
        }

        if (node.key > key) {
            node.right = searchNode(node.right, key);
        } else if (node.key < key) {
            node.left = searchNode(node.left, key);
        } else {
            System.out.println("해당 값을 가진 노드를 찾았습니다.");
        }

        return node;
    }

    public void descendingTraversal() {     // 좌측 중위 순회
        System.out.print("내림차순 순회 : ");
        rightInorderTraversal(root);
        System.out.println();
    }

    private void rightInorderTraversal(Node node) {
        if (node == null) {
            return;
        }
        rightInorderTraversal(node.right);
        System.out.printf("%d ", node.key);
        rightInorderTraversal(node.left);
    }

    public void ascendingTraversal() {      // 우즉 중위 순회
        System.out.print("오름차순 순회 : ");
        leftInorderTraversal(root);
        System.out.println();    }

    private void leftInorderTraversal(Node node) {
        if (node == null) {
            return;
        }
        leftInorderTraversal(node.left);
        System.out.printf("%d ", node.key);
        leftInorderTraversal(node.right);
    }
}

