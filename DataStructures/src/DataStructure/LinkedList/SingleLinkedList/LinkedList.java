package DataStructure.LinkedList.SingleLinkedList;

import java.util.Objects;
import java.util.Stack;

//singleLinkedList
public class LinkedList {
    //init a head node, not storing any data
    private Node headNode = new Node(0, "", "");

    public Node getHeadNode() {
        return headNode;
    }

    public void setHeadNode(Node headNode) {
        this.headNode = headNode;
    }

    /**
     * @param newNode add node into a list
     */
    public void add(Node newNode) {
        Node temp = headNode;
        while (true) {
            if (temp.next == null) {
                temp.next = newNode;
                break;
            } else {
                temp = temp.next;
            }
        }
    }

    /**
     * @param newNode add and sort it according to number
     */
    public void addByOrder(Node newNode) {
        boolean flag = true;
        //since it's a single linked list, "temp" is the node before the node position where we want to add into
        Node temp = headNode;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.num > newNode.num) {
                break;
            }
            if (temp.num == newNode.num) {
                flag = false;
                break;
            }
            temp = temp.next;
        }
        //if the num does not exist in the linked list, then it could be added
        if (flag) {
            //insert newNode between temp and temp.next
            newNode.next = temp.next;
            temp.next = newNode;
        } else {
            System.out.println("The node number " + newNode.num + " already exists. It can't be added.");
            return;
        }
    }

    /**
     * @param newNode update the information of a node
     */
    public void update(Node newNode) {
        if (headNode.next == null) {
            System.out.println("The linked list is empty.");
            return;
        }
        Node temp = headNode.next;
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

    public void delete(Node node) {
        Node temp = headNode;
        boolean flag = false;

        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.num == node.num && temp.next.name.equals(node.name) && temp.next.nickname.equals(node.nickname)) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            temp.next = temp.next.next;     //the node between temp and temp.next.next will be automatically deleted by JVM
        } else {
            System.out.println("There's no such a node in the list.");
        }
    }

    /**
     * traverse the linked list and print
     */
    public void list() {
        //whether the list is empty
        if (headNode.next == null) {
            System.out.println("The linked list is empty.");
            return;
        }

        //use an assisting variable to traverse the list
        Node temp = headNode.next;
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

    /**
     * @param head
     * @return valid node number
     * get the number of node in a linked list(except the head node)
     */

    public static int getLength(Node head) {
        if (head.next == null) {
            return 0;
        }
        Node temp = head;
        int num = 0;
        boolean loop = true;

        while (loop) {
            temp = temp.next;
            num++;
            if (temp.next == null) {
                loop = false;
            }
        }
        return num;
    }

    /**
     * find the kth to last node in the linked list
     * (???????????????k?????????)
     */
    public static Node getKthToLast(Node headNode, int k) {
        int len = getLength(headNode);
        if (len < k || 0 >= k) {
            //System.out.println("The list length is smaller than " + k + ". Can't find it.");
            return null;
        } else {
            Node temp = headNode;
            boolean loop = true;
            //start from head so len+1
            int index = len + 1;
            while (loop) {
                temp = temp.next;
                index--;      //index means the distance to the end
                if (index == k) {
                    loop = false;
                }
            }
            return temp;
        }
    }

    /**
     * reverse
     * ??????????????????
     * ?????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????
     * ????????????????????????????????????????????????
     * ????????????????????????
     * *  if (headNode.next == null || headNode.next.next == null) {
     * *             return;
     * *         }
     * *         Node reverseHead = new Node(0, "", "");
     * *         //use an assisting variable to traverse the list
     * *         Node temp = headNode.next;
     * *         while (temp != null) {
     * *             temp.next = reverseHead.next;
     * *             reverseHead.next = temp;
     * *             //continue
     * *             temp = temp.next;
     * *         }
     * *         headNode.next = reverseHead.next;
     */
    public void reverse() {
        //if the list is empty or if it only has 1 element, then it doesn't need to be reversed
        if (headNode.next == null || headNode.next.next == null) {
            return;
        }
        Node reverseHead = new Node(0, "", "");
        //use an assisting variable to traverse the list
        Node temp = headNode.next;
        //'next' stores the value of temp.next
        //??????while???????????????????????????temp.next???????????????????????????temp=temp.next???????????????????????????
        //?????????next??????????????????????????????temp.next?????????
        Node next = null;
        while (temp != null) {
            next = temp.next;
            //similar logic as addByOrder
            temp.next = reverseHead.next;
            reverseHead.next = temp;
            //continue
            temp = next;
        }
        headNode.next = reverseHead.next;
    }

    /**
     * Print reversely
     * ????????????
     * ????????????????????????????????????reverse??????????????????????????????????????????????????????????????????
     * ?????????????????????????????????????????????????????????????????????
     */

    public void reversePrint() {
        Stack<Node> stack = new Stack<Node>();
        if (headNode.next == null) {
            System.out.println("The linked list is empty.");
            return;
        }
        Node temp = headNode.next;
        while (temp != null) {
            stack.add(temp);
            temp = temp.next;
        }
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }

}

