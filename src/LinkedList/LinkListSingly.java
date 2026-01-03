package LinkedList;
/**
 * CLASS: LinkListSingly
 * --------------------
 * PURPOSE: Implements core algorithms for a Singly Linked List.
 * * TIME COMPLEXITY:
 * - Insert (Head): O(1)
 * - Insert (Tail): O(n)
 * - Insert (at Index): O(n)
 * - Delete (Head): O(1)
 * - Delete (Tail/Index): O(n)
 * - Search: O(n)
 * SPACE COMPLEXITY: O(n) for the total list.
 */
class LinkListSingly {
    private Node head;
    private Node tail;
    private int size;
    public LinkListSingly() {
        this.size = 0;
    }
    public void insertAtBeginning(int data) {
         Node node = new Node(data);
         node.setNext(head);
         head = node;
         if(tail == null) {
             tail = head;
         }
         size += 1;
    }
    public void insertAtEnd(int data) {
        if(tail == null) {
            insertAtBeginning(data);
            return;
        }
        Node node = new Node(data);
        tail.setNext(node);
        tail = node;
        size += 1;
    }
    public void insertAtParticularPos(int data, int index) {
        if (index == 0) {
            insertAtBeginning(data);
            return;
        }
        if (index == size) {
            insertAtEnd(data);
            return;
        }
        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.getNext();
        }
        Node newNode = new Node(data);
        newNode.setNext(temp.getNext());
        temp.setNext(newNode);
        size += 1;
    }
    public void deleteFirst() {
        if(head != null) {
            head = head.getNext();
            if (head == null) {
                tail = null;
            }
            size -= 1;
        }
    }
    public void deleteEnd() {
        if(head == null){
            return;
        }
        if(head.getNext()==null) {
            deleteFirst();
            return;
        }
        Node temp = head;
       while (temp.getNext().getNext() != null) {
           temp = temp.getNext();
       }
       tail = temp;
       tail.setNext(null);
       size -= 1;
    }
    public  void deleteElementAtPos(int index) {
        if(head == null || index <= 0){
            return;
        }
        if(index == 1) {
            deleteFirst();
            return;
        }
        Node temp = head;
        int i = 1;
        while (i++ < index-1) {
            temp = temp.getNext();
        }
        temp.setNext(temp.getNext().getNext());
        size -= 1;
    }
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.getData()+"->");
            temp = temp.getNext();
        }
        System.out.println("End");
    }
}