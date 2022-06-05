package DataStructure.Queue;

import java.util.Scanner;

public class ArrayQueue {
    //目前的数组使用一次之后就不能复用了，需要优化，用环形队列，见另一个类CircleQueue
    private int maxSize;
    private int front; //head of queue
    private int rear;  //end of queue
    private int[] arr;  //simulate a queue

    public ArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1;
        rear = -1;
    }

    //whether the queue is full
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    //whether the queue is empty
    public boolean isEmpty() {
        return rear == front;
    }

    //add element into the queue
    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("The queue is full. No elements can be added.");
            return;
        }
        rear++;
        arr[rear] = n;
    }

    //get out of the queue and get the data
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("The queue is empty.");
        }
        front++;
        return arr[front];
    }

    //display the queue
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("There's no data in the queue");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d] = %d\n", i, arr[i]);
        }
    }

    //show the head data of the queue
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("The queue is empty.");
        }
        return arr[front + 1];
    }

    public static void main(String[] args) {
        //Demo
        ArrayQueue queue = new ArrayQueue(3);
        //receive user input
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        //show a window
        while (loop) {
            System.out.println("s(show): Show the queue.");
            System.out.println("e(exit): Exit.");
            System.out.println("a(add): Add data to the queue.");
            System.out.println("g(get): Get data from the queue.");
            System.out.println("h(head): Look up the head data of the queue.");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("Input a number:");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = queue.getQueue();
                        System.out.printf("The data got is %d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = queue.headQueue();
                        System.out.printf("The head data is %d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("The program is exited.");
    }
}
