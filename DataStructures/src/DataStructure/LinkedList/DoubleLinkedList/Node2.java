package DataStructure.LinkedList.DoubleLinkedList;

public class Node2 {
    public int num;
    public String name;
    public String nickname;
    Node2 ahead;
    Node2 next;

    public Node2(int num, String name, String nickName) {
        this.num = num;
        this.name = name;
        this.nickname = nickName;

    }

    //for easy display
    public String toString() {
        return "Node [num = " + num + " , name = " + name + " , nick name = " + nickname +"]";
    }

}
