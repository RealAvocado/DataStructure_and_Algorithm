package DataStructure.Stack;

import java.util.concurrent.Callable;

/**
 * use stack to simulate a calculator
 */
public class CalculatorStack {
    private int size; //length of the stack
    private int[] stack;
    private int top = -1;  //position of the last element

    public CalculatorStack(int size) {
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
        if (isEmpty()) {
            System.out.println("The stack is empty.");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n", i, stack[i]);
        }
    }

    /**
     * decide the priority of operations
     * 判断运算符的优先级
     *
     * @param operation
     * @return
     */
    public int priority(int operation) {
        if (operation == '*' || operation == '/') {
            return 1;
        } else if (operation == '+' || operation == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    public boolean isOperation(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    /**
     * 返回栈顶的值 但不是真正的pop
     *
     * @param
     * @return
     */
    public int getTopOperation() {
        return stack[top];
    }

    /**
     * 进行计算器的每一次计算
     *
     * @param num1
     * @param num2
     * @param operation
     * @return
     */
    public int cal(int num1, int num2, int operation) {
        int res = 0;
        switch (operation) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }

    public static void main(String[] args) {
        String expression = "3+2*6-2";
        //set up two stack. An operation stack and a number stack
        CalculatorStack numberStack = new CalculatorStack(10);
        CalculatorStack operationStack = new CalculatorStack(10);
        //relevant variables
        int index = 0;//index to scan the expression
        int num1 = 0;
        int num2 = 0;
        int operation = 0;
        int res = 0;
        char ch = ' ';
        //scan the expression circularly
        while (true) {
            //read the number and operation one by one
            ch = expression.substring(index, index + 1).charAt(0);
            if (operationStack.isOperation(ch)) { //if it's an operation
                if (operationStack.isEmpty()) {
                    operationStack.push(ch);
                } else {
                    if (operationStack.priority(ch) <= operationStack.priority(operationStack.getTopOperation())) {
                        num1 = numberStack.pop();
                        num2 = numberStack.pop();
                        operation = operationStack.pop();
                        res = numberStack.cal(num1, num2, operation);
                        numberStack.push(res);
                        operationStack.push(ch);
                    } else {
                        operationStack.push(ch);
                    }
                }
            } else {//if it's a number
                numberStack.push(ch - 48);
            }
            index++;
            if (index >= expression.length()) {
                break;
            }
        }

        //after finishing scanning, calculate
        while (true) {
            num1 = numberStack.pop();
            num2 = numberStack.pop();
            operation = operationStack.pop();
            res = numberStack.cal(num1, num2, operation);
            numberStack.push(res);
            if (operationStack.isEmpty()) {
                break;
            }
        }
        System.out.println(res);
    }
}
