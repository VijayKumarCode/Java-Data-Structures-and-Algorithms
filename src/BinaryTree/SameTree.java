package BinaryTree;

/**
 * Problem No. #100
 * Difficulty: Easy
 * Description: Same Tree
 * Link: https://leetcode.com/problems/same-tree/
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 */

class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)  {
            return true;
        }
        if(p == null || q == null || p.val != q.val) {
            return false;
        }
        return isSameTree(p.left,q.left) && isSameTree(p.right, q.right);
    }
}