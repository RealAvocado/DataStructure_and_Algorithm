package DataStructure.LinkedList.DoubleLinkedList;

import DataStructure.LinkedList.SingleLinkedList.Node;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        Node2 hero1 = new Node2(1, "LeBronJames", "KingJames");
        Node2 hero2 = new Node2(2, "Wade", "Slash");
        Node2 hero3 = new Node2(3, "Davis", "AD");
        Node2 hero4 = new Node2(4, "Giannis", "Freak");

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addNode(hero1);
        doubleLinkedList.addNode(hero2);
        doubleLinkedList.addNode(hero3);
        doubleLinkedList.addNode(hero4);
        doubleLinkedList.list();
        System.out.println();

        doubleLinkedList.delete(hero3);
        doubleLinkedList.list();
        System.out.println();

        Node2 hero2New = new Node2(2,"Wade","DW");
        doubleLinkedList.update(hero2New);
        doubleLinkedList.list();

    }
}
