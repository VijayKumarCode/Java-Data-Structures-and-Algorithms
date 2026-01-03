package LinkedList; /**
 *  LEETCODE 142: Linked List Cycle II
 * ------------------------------------
 * PROBLEM: Given the head of a linked list, return the node where the cycle begins. 
 * If no cycle exists, return null.
 * * ALGORITHM STRATEGY: Floyd's Cycle-Finding Algorithm (Tortoise and Hare)
 * 1. Detection: Use a fast pointer (2 steps) and a slow pointer (1 step).
 * 2. Intersection: If they meet, a cycle exists.
 * 3. Finding Entrance: Reset the slow pointer to 'head' and move both pointers 
 * at a speed of 1 step. The node where they meet again is the start of the cycle.
 * MATHEMATICAL PROOF:
 * Let 'a' be the distance from head to cycle start, and 'b' be the distance 
 * from start to meeting point. The meeting occurs such that the entrance 
 * is equidistant from the head and the current meeting point.
 * COMPLEXITY ANALYSIS:
 * - Time Complexity: O(n) -> Linear traversal.
 * - Space Complexity: O(1) -> No extra memory used, only two pointers.
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class LinkListCycle2 {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
          slow = slow.next;
          fast = fast.next.next;
             if(slow == fast){
                ListNode entry = head;
                while(entry != slow) {
                 entry = entry.next;
                 slow = slow.next;
               }
               return entry;
            }
        }
        return null;
    }
}