package DataStructure.LinkedList.SingleLinkedList;

import static DataStructure.LinkedList.SingleLinkedList.LinkedList.*;

public class LinkedListDemo {
    public static void main(String[] args) {
        Node hero1 = new Node(1, "LeBronJames", "KingJames");
        Node hero2 = new Node(2, "Wade", "Slash");
        Node hero3 = new Node(3, "Davis", "AD");
        Node hero4 = new Node(4, "Giannis", "Freak");

        //init a new linked list
        LinkedList linkedList = new LinkedList();
        //add nodes into it
        linkedList.addByOrder(hero1);
        linkedList.addByOrder(hero4);
        linkedList.addByOrder(hero3);
        linkedList.addByOrder(hero2);
        //display the list
        linkedList.list();
        System.out.println();
        //update a node
        Node hero2New = new Node(2, "DwyaneWade", "D-WADE");
        linkedList.update(hero2New);
        System.out.println("After the linked list is updated:");
        linkedList.list();
        System.out.println();
        //delete a node
//        System.out.println("After the node is deleted");
//        linkedList.delete(hero2New);
//        linkedList.list();

        int len = getLength(linkedList.getHeadNode());
        System.out.println("The length of the linked list is " + len);

        Node res = getKthToLast(linkedList.getHeadNode(), 2);
        //Node kth = linkedList.getKthToLast(5);
        System.out.println("The 2nd to last node is:");
        System.out.println(res);
        System.out.println();

        //reverse the list
        //reverseList(linkedList.getHeadNode());
        linkedList.reverse();
        System.out.println("After the linked list is reversed:");
        linkedList.list();
        System.out.println();

        System.out.println("Print the list reversely");
        linkedList.reversePrint();

    }
}
