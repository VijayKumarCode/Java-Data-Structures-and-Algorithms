package LinkedList;
/**
 * DATA STRUCTURE: Node (Singly Linked List)
 * -----------------------------------------
 * DESCRIPTION:
 * The building block of a Singly Linked List. Contains data and 
 * a reference to the next node in the sequence.
 * COMPLEXITY:
 * - Space: O(1) per node.
 * - Access: O(1) for data/next pointer.
 */
class Node{
    private int data;
    private  Node next;
    public Node(int data) {
        this.data = data;
    }
    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
    public int getData() {
        return data;
    }
    public void setData(int data) {
        this.data = data;
    }
    public int getNext() {
        return next;
    }
    public void setNext(Node next) {
        this.next = next;
    }
}
