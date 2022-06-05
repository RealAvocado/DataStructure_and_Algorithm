package DataStructure.Queue;

import java.util.Scanner;

public class CircleQueue {
    //此环形队列最后一个位置是空出来的，也就是rear到front之间空着一个位置 所以元素个数最多是(maxSize-1)
    private int maxSize;  //capacity of the queue
    private int front; //head of queue (initial value is 0)
    private int rear;  //end of queue, pointing to the 'next position' of the last element (initial value is 0)
    private int[] arr;  //simulate a queue

    public CircleQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
    }

    //whether the queue is full
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
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
        arr[rear] = n;
        //use mod because it's a circle queue
        //rear的位置要取模，环形队列的性质（rear指向最后一个元素的下一个位置）
        rear = (rear + 1) % maxSize;
    }

    //get out of the queue and get the data
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("The queue is empty.");
        }
        int value = arr[front];
        //use mod because it's a circle queue
        front = (front + 1) % maxSize;
        return value;
    }

    //display the queue
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("There's no data in the queue");
            return;
        }
        //go through the queue from 'front', number of element need to me calculated
        //size = ((rear - front) + maxSize) % maxSize
        for (int i = front; i < front + size(); i++) {
            //mod
            System.out.printf("arr[%d] = %d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    //get the number of valid elements in the queue
    public int size() {
        return ((rear - front) + maxSize) % maxSize;
    }

    //show the head data of the queue
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("The queue is empty.");
        }
        return arr[front];
    }

    public static void main(String[] args) {
        //Demo
        CircleQueue queue = new CircleQueue(4);
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
