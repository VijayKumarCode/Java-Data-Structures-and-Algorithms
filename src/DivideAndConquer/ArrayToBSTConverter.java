package DivideAndConquer;

/**
 * Problem No. #108
 * Difficulty: Easy
 * Description: Convert Sorted Array to Binary Search Tree
 * Link: https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 * Time Complexity: O(n)
 * Space Complexity: O(log n)
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

 class ArrayToBSTConverter {
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBalancedBST(nums, 0, nums.length - 1);
    }

    private TreeNode buildBalancedBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        // Choosing the middle element to maintain balance
        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(nums[mid]);

        // Recursively build the left and right subtrees
        node.left = buildBalancedBST(nums, left, mid - 1);
        node.right = buildBalancedBST(nums, mid + 1, right);

        return node;
    }
}