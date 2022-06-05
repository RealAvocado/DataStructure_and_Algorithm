package DataStructure.LinkedList.Josephus;

import DataStructure.LinkedList.SingleLinkedList.Node;

public class JosephusDemo {
    public static void main(String[] args) {
        Node hero1 = new Node(1, "LeBronJames", "KingJames");
        Node hero2 = new Node(2, "Wade", "Slash");
        Node hero3 = new Node(3, "Davis", "AD");
        Node hero4 = new Node(4, "Giannis", "Freak");
        CircleSingleLinkedList circleSingleLinkedList=new CircleSingleLinkedList();
        /*circleSingleLinkedList.add(hero1);
        circleSingleLinkedList.add(hero2);
        circleSingleLinkedList.add(hero3);
        circleSingleLinkedList.add(hero4);*/
        //circleSingleLinkedList.addBatchOfNodes(5);
        //circleSingleLinkedList.list();
        circleSingleLinkedList.josephusCircle(1,2,5);
        //circleSingleLinkedList.list();
    }
}
