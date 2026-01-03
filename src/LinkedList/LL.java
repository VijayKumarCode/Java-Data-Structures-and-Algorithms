package LinkedList;
/**
 * CLASS: LL
 * ---------
 * PURPOSE: Main driver class to execute and test LinkListSingly operations.
 * * FUNCTIONALITY:
 * - Initializes the list.
 * - Performs various test cases (Insert, Delete, Search).
 * - Displays the list state to the console.
 */
public class LL {
    public static void main(String[] args) {
        LinkListSingly list = new LinkListSingly();
        list.insertAtBeginning(10);
        list.insertAtBeginning(11);
        list.insertAtBeginning(15);
        list.insertAtBeginning(20);
        list.insertAtBeginning(30);
        list.display();
        System.out.println("Started inserted at end");
        list.insertAtEnd(50);
        list.insertAtEnd(62);
        list.display();
        System.out.println("Inserted at Position ");
        list.insertAtParticularPos(21,5);
        list.display();
        list.deleteFirst();
        System.out.println("Deleted element from first ");
        list.display();
        list.deleteEnd();
        System.out.println("Deleted element from end  ");
        list.display();
        list.deleteElementAtPos(3);
        list.display();
    }
}