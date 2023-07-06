package Algorithm.Stack;

public class ArrayStack {
    int size;
    int top =  -1;
    Object[] stack;

    public ArrayStack(int size) {       // ArrayStack 생성
        this.size = size;       // 크기 지정
        stack = new Object[size];       // 해당 크기만큼인 스택 생성
    }

    public Object pop() {       // pop 연산
        if(isEmpty())       // stack이 비어있다면 예외 발생
            throw new ArrayIndexOutOfBoundsException();

        Object poppedData = stack[top];     // 최상단 데이터를 popedData에 담아서
        stack[top--] = null;        // 최상단 데이터를 지우고 top 위치 감소

        return poppedData;      // 반환
    }

    public void push(Object data) {     // push 연산
        if(isFull())        // stack이 꽉 찬 상태면 예외 발생
            throw new ArrayIndexOutOfBoundsException();

        this.stack[++top] = data;       // 본래 top 위치에 data 삽입 후 top 위치 증가
    }

    public Object peek() {      // peek 연산(값만 꺼내옴, remove가 아님!)
        if(isEmpty())   // 비어있다면 null
            return null;
        else        // 비어있지 않으면 top에 있단 값 반환
            return this.stack[top];
    }

    public boolean isEmpty() {      // 공백 체크
        return top == -1;       // top의 초기 위치는 -1. 즉 top == -1 -> true이면 공백
    }

    public boolean isFull() {       // 꽉 찬 상태 체크
        return this.size == this.top + 1;       // top의 초기 위치는 -1이기 때문에 +1한 값이 size와 같으면 full 상태
    }
}
