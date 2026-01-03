package LinkedList;
/**
 * LEETCODE 141: Floyd's Cycle-Finding (Tortoise and Hare)
 * ------------------------------------------------------
 * PROBLEM: Given the head of a linked list, determine if the list has a cycle(Leetcode 141).
 * * LOGIC:
 * - Use two pointers moving at different speeds (Slow: 1 step, Fast: 2 steps).
 * - If there is no cycle, the fast pointer will eventually reach the end (null).
 * - If there is a cycle, the fast pointer will eventually "lap" the slow pointer,
 * and they will meet at the same node.
 * COMPLEXITY ANALYSIS:
 * - Time Complexity: O(n) -> In the worst case, we traverse each node once.
 * - Space Complexity: O(1) -> Only two pointers are used, regardless of list size.
 * ADVANTAGE: 
 * This approach is superior to using a HashSet, which would require O(n) extra space.
 * Definition for singly-linked list.
 * static class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class LinkListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
             fast = fast.next.next;
             slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }
}