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
 *
 * SPACE COMPLEXITY: O(n) for the total list.
 */
class LinkListSingly {
    private Node head;
    private Node tail;
    private int size;
    public LinkListSingly() {
        this.size = 0;
    }
    public void insertAtBeginning(int data){
         Node node = new Node(data);
         node.next = head;
         head = node;

         if(tail == null){
             tail = head;
             return;
         }
         size += 1;
    }
    public void insertAtEnd(int data){
        if(tail == null){
            insertAtBeginning(data);
            return;
        }
        Node node = new Node(data);
        tail.next = node;
        tail = node;
        size += 1;
    }
    public void insertAtParticularPos(int data, int index){
        if (index == 0){
            insertAtBeginning(data);
            return;
        }
        if (index == size){
            insertAtEnd(data);
            return;
        }
        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        Node node = new Node(data,temp.next);
        temp.next = node;
        size += 1;
    }
    public void deleteFirst(){
        if(head != null){
            head = head.next;
        }
    }
    public void deleteEnd(){
        if(head == null){
            return;
        }
        if(head.next==null){
            deleteFirst();
            return;
        }
        Node temp = head;
       while (temp.next.next != null ){
           temp = temp.next;
       }
       int val = tail.data;
       tail = temp;
       tail.next = null;
    }

    public  void deleteElementAtPos(int index){
        if(head == null || index <= 0){
            return;
        }
        if(index == 1){
            deleteFirst();
        }
        Node temp = head;
        int i = 1;
        while (i++ < index-1){
            temp = temp.next;
        }
        temp.next = temp.next.next;
    }
    public void display(){
        Node temp = head;
        while (temp != null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println("End");
    }
}
