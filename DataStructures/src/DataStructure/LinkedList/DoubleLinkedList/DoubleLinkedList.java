package DataStructure.LinkedList.DoubleLinkedList;

import DataStructure.LinkedList.SingleLinkedList.Node;

public class DoubleLinkedList {
    private Node2 headNode = new Node2(0, "", "");
    //private Node2 endNode = new Node2(0, "", "");

    public Node2 getHeadNode() {
        return headNode;
    }

    public void setHeadNode(Node2 headNode) {
        this.headNode = headNode;
    }

//   public Node2 getEndNode() {
//        return endNode;
//    }
//
//    public void setEndNode(Node2 endNode) {
//        this.endNode = endNode;
//    }
//
//    public void initNode() {
//        headNode.next = endNode;
//        endNode.ahead = headNode;
//    }

    /**
     * @param newNode add node into a list
     *                这个方法设了一个end node，但其实不用这样。因为链表最后一个node的next会默认为null
     *//*
    public void add(Node2 newNode) {
        if (headNode.next == null) { //means the list is empty
            initNode();
            headNode.next = newNode;
            newNode.ahead = headNode;
            endNode.ahead = newNode;
            newNode.next = endNode;
        } else {//insert newNode between endNode.ahead and endNode
            //link newNode with endNode.ahead
            newNode.ahead = endNode.ahead;
            endNode.ahead.next = newNode;
            //link newNode with endNode
            endNode.ahead = newNode;
            newNode.next = endNode;
        }
    }*/

    /**
     * add node into the linked list
     * 向双向链表里添加节点(和单链表的类似，稍加改动)
     */
    public void addNode(Node2 newNode) {
        Node2 temp = headNode;
        while (true) {
            if (temp.next == null) {
                break;
            } else {
                temp = temp.next;
            }
        }
        temp.next = newNode;
        newNode.ahead = temp;
    }

    /**
     * @param newNode update the information of a node
     */
    public void update(Node2 newNode) {
        if (headNode.next == null) {
            System.out.println("The linked list is empty.");
            return;
        }
        Node2 temp = headNode.next;
        boolean flag = false;

        while (true) {
            if (temp == null) { //has finished the traversal of the linked list
                break;
            }
            if (temp.num == newNode.num) { //find the node that we want to modify
                flag = true;
                break;
            }
            temp = temp.next;  //traverse
        }
        if (flag) {
            temp.name = newNode.name;
            temp.nickname = newNode.nickname;
        } else {
            System.out.println("The node with num = " + newNode.num + " isn't found.");
        }
    }

    /**
     * 从双向链表中删除节点
     * delete the node between temp.ahead and temp.next
     * @param node
     */
    public void delete(Node2 node) {
        Node2 temp = headNode.next;
        boolean flag = false;

        while (true) {
            if (temp == null) { //最远会遍历到最后一个节点的next节点
                break;
            }
            if (temp.num == node.num && temp.name.equals(node.name) && temp.nickname.equals(node.nickname)) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            temp.ahead.next = temp.next;     //the node between temp.ahead and temp.next will be automatically deleted by JVM
            //这句话要加判断条件 只有当删除的不是最后一个节点的时候，才能将temp.next.ahead指向temp.ahead
            //如果删除的是最后一个节点的时候 下面这句话会出现空指针异常，因为此时temp.next=null，null的ahead是不存在的
            if(temp.next!=null) {
                temp.next.ahead = temp.ahead;
            }
        } else {
            System.out.println("There's no such a node in the list.");
        }
    }

    /**
     * print the list
     * traverse the linked list and print
     */
    public void list() {
        //whether the list is empty
        if (headNode.next == null) {
            System.out.println("The linked list is empty.");
            return;
        }

        //use an assisting variable to traverse the list
        Node2 temp = headNode.next;
        while (true) {
            //whether access the end of the list
            if (temp == null) {
                break;
            }
            //output current node
            System.out.println(temp);
            temp = temp.next;
        }
    }

}
