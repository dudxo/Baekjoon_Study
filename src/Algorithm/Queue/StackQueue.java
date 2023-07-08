package Algorithm.Queue;

public class StackQueue {
    int length;     // Queue의 길이
    int front = 0;  // front
    int rear = 0;   // rear
    Object[] queue; // 배열 queue 생성

    /* enqueue 또는 dequeue 시 항상 isEmpty, isFull 상태인지 체크 필요!*/

    public void enqueue(Object data) {      // 삽입 연산
        if (isFull()) {     // 공백 체크
            throw new ArrayIndexOutOfBoundsException();
        }
        queue[rear++] = data;       // rear에 data 삽입 후 증가
        rear = rear % queue.length;     // Queue의 크기를 넘지 못하도록 연산
    }

    public Object dequeue() {       // 삭제 연산
        if (isEmpty()) {        // 공백 체크
            throw new ArrayIndexOutOfBoundsException();
        }
        Object dequeueData = queue[front];      // 가장 먼저 들어온 들어온 data를 dequeueData에 담고
        queue[front++] = null;      // 해당 위치 null 초기화 후 fron 이동
        front = front % queue.length;       // Queue의 크기를 넘지 못하도록 연산

        return dequeueData;     // 삭제된 data return
    }

    public Object peek() {      // 가장 먼저 나올 data 꺼내오기  * remove X
        if (isEmpty()) {        // 공백 체크
            System.out.println("Queue is Empty");;

            return -1;      // 공백이면 -1 return
        }
        return queue[front];        // 가장 먼저 나올 data return
    }

    public boolean isEmpty() {      // 공백 체크
        return front == rear && queue[front] == null;
    }

    public boolean isFull() {       // 포화 상태 체크
        return front == rear && queue[front] != null;
    }
}
