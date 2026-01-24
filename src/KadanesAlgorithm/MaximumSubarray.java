package KadanesAlgorithm;

/*
Problem No. #53
Difficulty: Medium
Description: Maximum Subarray
Link: https://leetcode.com/problems/maximum-subarray/
Time Complexity: O(n)
Space Complexity: O(1)
*/

class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) return nums[0];

        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Deciding whether to start a new subarray at nums[i]
            // or continue the existing one
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}
