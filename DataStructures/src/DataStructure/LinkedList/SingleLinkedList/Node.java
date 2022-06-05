package DataStructure.LinkedList.SingleLinkedList;

public class Node {
    public int num;
    public String name;
    public String nickname;
    public Node next;

    public Node(int num, String name, String nickName) {
        this.num = num;
        this.name = name;
        this.nickname = nickName;

    }

    //for easy display
    public String toString() {
        return "Node [num = " + num + " , name = " + name + " , nick name = " + nickname +"]";
    }


}
