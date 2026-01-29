package KadanesAlgorithm;

/*
Problem No. #918
Difficulty: Medium
Description: Maximum Sum Circular Subarray
Link: https://leetcode.com/problems/maximum-sum-circular-subarray/
Time Complexity: O(n)
Space Complexity: O(1)
*/

class CircularSubarraySum {

    public static int maxSubarraySumCircular(int[] nums) {
        int currMin = nums[0], currMax = nums[0], maxSum = nums[0], minSum = nums[0];
        int totalSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Standard Kadane's to find max subarray sum
            currMax = Math.max(nums[i], currMax + nums[i]);
            maxSum = Math.max(maxSum, currMax);

            // Kadane's variation to find min subarray sum
            currMin = Math.min(nums[i], currMin + nums[i]);
            minSum = Math.min(minSum, currMin);

            totalSum += nums[i];
        }

        // If all elements are negative, maxSum is the answer (prevents returning 0)
        if (minSum == totalSum) {
            return maxSum;
        }

        // Return the maximum of non-circular (maxSum) and circular (totalSum - minSum)
        return Math.max(maxSum, totalSum - minSum);
    }
}