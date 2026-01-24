package DivideAndConquer;

/**
 * Problem No. #23
 * Difficulty: Hard
 * Description: Merge k Sorted Lists
 * Link: https://leetcode.com/problems/merge-k-sorted-lists/
 * Time Complexity: O(N log k)
 * Space Complexity: O(log k)
 */
 class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return divideAndConquer(lists, 0, lists.length - 1);
    }

    public ListNode divideAndConquer(ListNode[] list, int start, int end) {
        if (start == end) return list[start];

        int mid = start + (end - start) / 2;

        ListNode left = divideAndConquer(list, start, mid);
        ListNode right = divideAndConquer(list, mid + 1, end);
        ListNode dummy = new ListNode(0);
        return mergeAll(dummy, left, right);
    }

    public ListNode mergeAll(ListNode dummy, ListNode left, ListNode right) {
        ListNode list = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                list.next = left;
                left = left.next;
            } else {
                list.next = right;
                right = right.next;
            }
            list = list.next;
        }
        list.next = (left != null) ? left : right;
        return dummy.next;
    }
}