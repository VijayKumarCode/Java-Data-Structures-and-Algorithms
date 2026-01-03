package LinkedList;
/*  LEETCODE 21: Merge Two Sorted Lists
 * -------------------------------------
 * PROBLEM: Merge two sorted linked lists into one sorted list by splicing nodes.
 * * ALGORITHM STRATEGY:
 * 1. Iterative Approach: Use a dummy node to act as the starting point of the merged list.
 * 2. Comparison: Compare the 'val' of head nodes from both lists.
 * 3. Splicing: Attach the smaller node to the merged list and move that list's pointer forward.
 * 4. Cleanup: If one list finishes early, attach the remainder of the other list.
 * COMPLEXITY ANALYSIS:
 * - Time Complexity: O(n + m) -> We visit every node in both lists once.
 * - Space Complexity: O(1) -> We are rearranging existing nodes, not creating new ones.
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {
 *     }
 *     ListNode(int val) { 
 *      this.val = val; 
 *     }
 *     ListNode(int val, ListNode next) { 
 *     this.val = val; this.next = next; 
 *     }
 * }
 */
class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode joinedLists = dummy;
        ListNode head1 = list1;
        ListNode head2 = list2;
        while(head1 != null && head2 != null) {
            if(head1.val < head2.val){
                joinedLists.next = head1;
                head1 = head1.next;
            }
            else {
                joinedLists.next = head2;
                head2 = head2.next;
            }
                joinedLists = joinedLists.next;
        }
        while(head1 != null) {
            joinedLists.next = head1;
            head1 = head1.next;
            joinedLists = joinedLists.next;
        }
        while(head2 != null) {
            joinedLists.next = head2;
            head2 = head2.next;
            joinedLists = joinedLists.next;
        }
        return dummy.next;
    }
}