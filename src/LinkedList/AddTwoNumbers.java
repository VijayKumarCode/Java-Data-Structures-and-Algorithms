package LinkedList;
/**
 * 🔗 LEETCODE 2: Add Two Numbers
 * ------------------------------
 * PROBLEM: Given two non-empty linked lists representing two non-negative 
 * integers (digits stored in reverse order), add the two numbers and 
 * return the sum as a linked list.
 * * ALGORITHM STRATEGY: Elementary Math Addition
 * 1. Dummy Node: Use a dummy head to simplify list construction.
 * 2. Traversal: Iterate while l1, l2, or a remaining carry exists.
 * 3. Summation: Sum the values of current nodes and the carry.
 * 4. Carry Logic: Update carry (total / 10) and current digit (total % 10).
 * 5. Node Creation: Link new nodes with the calculated digit.
 * COMPLEXITY ANALYSIS:
 * - Time Complexity: O(max(m, n)) -> Where m and n are lengths of l1 and l2.
 * - Space Complexity: O(max(m, n)) -> The length of the new list is at most max(m, n) + 1.
 */
class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      ListNode dummy = new ListNode(-1);
      ListNode result = dummy;
      int total = 0;
      int carry = 0;
      while(l1 != null || l2 != null || carry != 0) {
        total = carry;
        if(l1 != null) {
            total += l1.val;
            l1 = l1.next;
        }
        if(l2 != null) {
            total += l2.val;
            l2 = l2.next;
        }
        int num = total % 10;
        carry = total/10;
        dummy.next = new ListNode(num);
        dummy = dummy.next;
      }
      return result.next; 
    }
}