package BinaryTree;

/*
Problem No. #117
Difficulty: Medium
Description: Populating Next Right Pointers in Each Node II
Link: https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
Time Complexity: O(n)
Space Complexity: O(1)
*/

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

class PopulatingNextRightPointersII {
    public Node connect(Node root) {
        if (root == null) return null;

        // curr represents the start of the level we are currently traversing
        Node curr = root;

        while (curr != null) {
            // dummy acts as a placeholder for the start of the next level
            Node dummy = new Node(0);
            // tail is used to connect nodes on the next level
            Node tail = dummy;

            // This inner loop moves horizontally across the current level
            while (curr != null) {
                if (curr.left != null) {
                    tail.next = curr.left;
                    tail = tail.next;
                }

                if (curr.right != null) {
                    tail.next = curr.right;
                    tail = tail.next;
                }

                // Move to the next node in the current level
                curr = curr.next;
            }

            // After finishing the current level, move to the start of the next level
            // dummy.next points to the first node of the level we just stitched
            curr = dummy.next;
        }

        return root;
    }
}
