package LinkedList;

/*
Problem No. #25
Difficulty: Hard
Description: Reverse Nodes in k-Group
Link: https://leetcode.com/problems/reverse-nodes-in-k-group/
Time Complexity: O(n)
Space Complexity: O(n/k)
*/

 class ListNode {
     int val;
     ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return null;

        ListNode tail = head;
        for (int i = 0; i < k; i++) {
            if(tail == null) return head;
            tail = tail.next;
        }

        ListNode newHead = reverse(head,tail);
        head.next = reverseKGroup(tail,k);
        return newHead;
    }

    private ListNode reverse(ListNode curr, ListNode end) {
        ListNode prev = null;

        while(curr != end) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
