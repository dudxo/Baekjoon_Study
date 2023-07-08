package Algorithm.Queue;

public class ListQueue<T> {
    Node<T> front = null;       // front null 초기화
    Node<T> rear = null;        // rear null 초기화

    public void enqueue(T data) {       // 삽입 연산
        Node<T> newNode = new Node<>();     // 추가될 노드(newNode) 생성
        newNode.data = data;        // newNode의 data 삽입

        if (isEmpty()) {        // 공백이라면
            front = newNode;        // front가 newNode 참조
        } else {        // 공백이 아니라면
            rear.next = newNode;        // 마지막 노드(rear.next)는 newNode를 참조하고
        }
        rear = newNode;     // 공백이든 아니든 rear는 마지막 노드인 newNode를 참조
    }

    public T dequeue() {        // 삭제 연산
        if (isEmpty()) {        // 공백 상태
            throw new ArrayIndexOutOfBoundsException();
        }

        T data = front.data;        // 삭제될 data를 임시변수 data에 담고

        /* 참조 되지않는 객체(삭제 될 노드)는 Garbage Collector에 의해 자동 삭제됨!*/

        if (front == rear) {        // 노드가 1개인 상태라면
            front = null;       // front와 rear를 null로 초기화 시켜 공백상태로 만듦
            rear = null;
        } else {        // 노드가 2개 이상이라면
            front = front.next;
        }
        return data;
    }

    public T peek() {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException();
        }

        return front.data;
    }

    public boolean isEmpty() {
//        return front == rear && front == null;
//        큐가 비어있다면 front와 rear 두 노드가 존재하지 않기 때문에 front가 null값인지만 체크
        return front == null;
    }

    public T search(T data) {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        Node<T> searchData = front;
        while (searchData.data != null) {
            if (data.equals(searchData.data)) {
                return searchData.data;
            } else {
                searchData = searchData.next;
            }
        }
        return null;
    }
}
