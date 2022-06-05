package DataStructure.Stack;

public class ArrayStack {
    private int size; //length of the stack
    private int[] stack;
    private int top = -1;  //position of the last element

    public ArrayStack(int size) {
        this.size = size;
        stack = new int[this.size];
    }

    public boolean isFull() {
        return top == size - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 入栈
     *
     * @param value
     */
    public void push(int value) {
        if (isFull()) {
            System.out.println("The stack is full.");
            return;
        }
        top++;
        stack[top] = value;
    }

    /**
     * 出栈
     */
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("The stack is empty.");
        }
        int value = stack[top];
        top--;
        return value;
    }

    /**
     * 遍历
     * 从栈顶开始显示数据
     */
    public void list() {
        if(isEmpty()){
            System.out.println("The stack is empty.");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n", i, stack[i]);
        }
    }
}
