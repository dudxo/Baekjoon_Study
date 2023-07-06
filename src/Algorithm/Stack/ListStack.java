package Algorithm.Stack;

public class ListStack<T> {
    Node<T> head = null;        // head 초기화(head == 최상단/마지막 Node 참조)
    Node<T> buttom = null;      // buttom 초기화(buttom == 최하단/첫 Node 참조)

    public boolean isEmpty() {      // 공백 체크
        return head == null;        // head가 null이면 not data
    }

    public void push(T data) {      // push 연산(최상단에 새로운 요소 추가)
        // ListStack은 동적이기 때문에 push 연산시 예외처리를 하지 않아도 됨
        Node<T> newNode = new Node<>();     // newNode 생성
        newNode.data = data;        // newNode data 지정

        if (!isEmpty()) {       // 공백이 아니라면 다른 Node가 있다는 뜻이니
            newNode.next = this.head;       // newNode가 원래 head가 갖고 있던 곳(가장 상단 Node)을 참조하고
        }
        this.head = newNode;        // head는 newNode를 참조
    }

    public T pop() {        // pop 연산(최상단 요소 삭제 및 반환)
        if(isEmpty())       // 공백이면 예외 발생
            throw new ArrayIndexOutOfBoundsException();

        T tmp = this.head.data; // pop Node(상단 Node)의 값 임시 저장
        Node<T> popedNode = this.head;      // popeedNode는 삭제되는 Node 자체를 참조
        this.head = this.head.next;     // head는 삭제할 Node 다음 Node 자체를 참조

        popedNode.next = null;      // pop Node의 참조하는 주소 null 할당
        popedNode.data = null;      // pop Node의 data null 할당

        return tmp;     // pop Node의 data를 임시저장한 tmp를 return
    }

    public T peek() {       // peek 연산(삭제하지 않고 값만 반환)
        if(isEmpty())       // 공백이라면
            return null;        // null 반환

        return this.head.data;      // 공백이 아니면 최상단(head) data return
    }

}
