package BinaryTree;

import java.util.ArrayDeque;
import java.util.Deque;
/**
 * Problem No. #173
 * Difficulty: Medium
 * Description: Binary Search Tree Iterator
 * Link: https://leetcode.com/problems/binary-search-tree-iterator/
 * Time Complexity: $O(1)$ average
 * Space Complexity: $O(h)$
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class BstIterator {
    private Deque<TreeNode> stack;

    public BstIterator(TreeNode root) {
        this.stack = new ArrayDeque<>();
        // Start by finding the smallest element
        pushAllLeft(root);
    }

    /** * Returns the next smallest number.
     * Amortized time complexity is $O(1)$ because each node is pushed
     * and popped exactly once.
     */

    public int next() {
        TreeNode node = stack.pop();

        // If the node has a right child, we need to explore its leftmost path
        if (node.right != null) {
            pushAllLeft(node.right);
        }

        return node.val;
    }

    /** Returns whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void pushAllLeft(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}