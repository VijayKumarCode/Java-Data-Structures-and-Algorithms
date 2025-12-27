/**
 * 🔄 ALGORITHM: Reverse Linked List II (Partial Reversal)
 * ------------------------------------------------------
 * PROBLEM: (Leetcode 092) Reverse a sub-section of a linked list from position 'left' to 'right'.
 * * KEY STRATEGIES:
 * 1. Dummy Node: Used to handle the edge case where the head itself needs to be reversed.
 * 2. Navigation: Traversed to the (left - 1) position to maintain a reference to the 
 * non-reversed part.
 * 3. In-Place Reversal: Reverses exactly (right - left + 1) nodes.
 * 4. Re-linking: Connects the 'prev' node to the new sub-list head and the original 
 * sub-list tail to the remaining list.
 *
 * COMPLEXITY ANALYSIS:
 * - Time Complexity: O(n) -> We traverse the list at most once.
 * - Space Complexity: O(1) -> Performed in-place without extra data structures.
 */
class ReverseLinkList2{
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || head.next == null || left == right) {
            return head;
        }
         ListNode dummy = new ListNode(0);
         dummy.next = head;
         ListNode prev = dummy;
         ListNode temp = head;
        int i = 1;
        while(i++ < left) {
            prev = temp;
            temp = temp.next;
        }
        ListNode reverseHeadAndRight = reverse(temp,left,right);
        prev.next = reverseHeadAndRight;
        return dummy.next;
    }
    public ListNode reverse(ListNode temp, int left, int right) {
           ListNode prev = null;
           ListNode nextNode = null;
           ListNode curr = temp;
         while(left++ <= right) {
           nextNode = curr.next;
           curr.next = prev;
           prev = curr;
           curr = nextNode;
        } 
        temp.next = curr;
        return prev;
    }
}

