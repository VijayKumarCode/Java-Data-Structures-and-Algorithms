package SlidingWindow;
/**
 * Problem: Minimum Size Subarray Sum
 * Goal: Find the minimal length of a contiguous subarray of which the sum ≥ target.
 * * Strategy: Sliding Window (Two Pointers)
 * Time Complexity: O(n) - Each element is visited at most twice.
 * Space Complexity: O(1) - No extra space used.
 */
class MinSubArray {
    public int minSubArrayLen(int target, int[] array) {
        int minLength = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int currentSum = 0;
        while (right < array.length) {
            // Expand the window by adding elements from the right
            currentSum += array[right];
            right++;
            // Shrink the window from the left as long as the sum is >= target
            while (currentSum >= target) {
                int len = right - left;
                minLength = Math.min(minLength, len);
                // Remove element from the left and move the pointer
                currentSum -= array[left];
                left++;
            }
        }
        // If minLength was never updated, return 0
        return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
    }
}