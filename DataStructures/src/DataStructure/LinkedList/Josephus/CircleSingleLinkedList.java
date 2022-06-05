package DataStructure.LinkedList.Josephus;

import DataStructure.LinkedList.SingleLinkedList.Node;

/**
 * 环形单向链表
 */
public class CircleSingleLinkedList {
    private Node initNode = null;

    public Node getInitNode() {
        return initNode;
    }

    /**
     * @param newNode add node into a list
     */
    public void add(Node newNode) {
        if (initNode == null) {//when the circle list is empty
            //form a circle
            //起始节点要自己和自己形成一个环形链表，以便后续添加
            initNode = newNode;
            newNode.next = initNode;
        }
        Node temp = initNode;
        while (true) {
            if (temp.next == initNode) {
                //add new node into the circle
                temp.next = newNode;
                newNode.next = initNode;
                break;
            } else {
                temp = temp.next;
            }
        }
    }

    /**
     * Add batch of nodes
     * 批量自动加入节点，生成一个环形链表
     * add()方法的升级
     *
     * @param amount
     */
    public void addBatchOfNodes(int amount) {
        if (amount < 1) { //amount is the amount of nodes to be added
            System.out.println("Invalid amount.");
            return;
        }
        //current node (help to traverse the list)
        Node curNode = null;
        //use for loop to construct the circle list
        for (int i = 1; i <= amount; i++) {
            //node to be added
            //automatically be added in the order of num
            Node newNode = new Node(i, "", "");
            if (i == 1) {//加入的第一个节点 单独处理
                initNode = newNode;
                newNode.next = initNode; //form a circle
                curNode = initNode;
            } else {
                curNode.next = newNode;
                newNode.next = initNode;
                curNode = newNode; //move the assist variable curNode to newNode. same as(curNode=curNode.next)
            }
        }

    }

    /**
     * traverse the linked list and print
     * 显示链表
     */
    public void list() {
        //whether the list is empty
        if (initNode == null) {
            System.out.println("The linked list is empty.");
            return;
        }

        //use an assisting variable to traverse the list
        Node temp = initNode;
        while (true) {
            //output current node
            System.out.println(temp);
            temp = temp.next;
            //whether access the end of the list
            if (temp == initNode) { //have gone back to the initNode, then stop because it's a circle.
                break;
            }
        }
    }

    /**
     * 设编号为1，2，… n的n个人围坐一圈，约定编号为k（1<=k<=n）的人从1开始报数，
     * 数到m 的那个人出列，它的下一位又从1开始报数，数到m的那个人又出列，依次类推，
     * 直到所有人出列为止，由此产生一个出队编号的序列。
     * Josephus circle
     *
     * @param startNo  从第几个节点开始数
     * @param countNum 数多少下
     * @param nums     初始节点的总数
     */
    public void josephusCircle(int startNo, int countNum, int nums) {
        //build a circle having nums nodes
        addBatchOfNodes(nums);
        System.out.println("Initial circle:");
        list();
        //verify the parameters
        if (initNode == null || startNo < 1 || startNo > nums) {
            System.out.println("The parameters are wrong.");
            return;
        }

        //cur代表着此刻指向的节点，helper是cur的前一个节点，作用是一轮数数完毕之后，借助helper方便删除cur节点
        //删除的语句在下面 是cur=cur.next; helper=helper.next;
        Node helper = initNode;
        Node cur = initNode;
        while (true) { //initialize the helper node as the last node of the circle
            if (helper.num == nums) {
                break;
            }
            helper = helper.next;
        }
        while (true) { //initialize the current node to the startNo, and helper is the one before cur
            if (cur.num == startNo) {
                break;
            }
            cur = cur.next;
            helper = helper.next;
        }
        //start getting nodes out of circle
        //开始约瑟夫环的出环步骤
        System.out.println("Start moving nodes out of the Josephus circle:");
        while (true) {
            for (int i = 0; i < countNum - 1; i++) { //数第一个数的时候是自己在数，所以数n个数实际前进n-1步，所以是countNum-1
                cur = cur.next;
                helper = helper.next;
            }
            System.out.println("The node "+ cur.num + " is moved out of the circle.");

            cur = cur.next;    //these 2 lines: helper不移动，而是把helper的next指向被删节点cur的下一个节点
            helper.next = cur; //delete cur, move cur out of the circle,and let cur step to the next node

            if (cur == cur.next) { //there's only one node left
                System.out.println("The node "+ cur.num + " is moved out of the circle.");
                break;
            }
        }
        initNode=cur; //这一步是为了list()方法能使用 不然initNode就指向不明确了
    }

}
