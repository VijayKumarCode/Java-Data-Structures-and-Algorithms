package BinarySearch;

/**
 * Problem No. #162
 * Difficulty: Medium
 * Description: Find Peak Element
 * Link: https://leetcode.com/problems/find-peak-element/
 * Time Complexity: O(log n)
 * Space Complexity: O(log n)
 */

class PeakFinder {
    public int findPeakElement(int[] nums) {
        // We use nums.length - 1 to stay within bounds when checking mid + 1
        return findPeakPos(nums, 0, nums.length - 1);
    }

    public int findPeakPos(int[] nums, int start, int end) {
        // Base case: when start meets end, we've found a peak index
        if (start == end) {
            return start;
        }

        int mid = start + (end - start) / 2;

        // If mid is less than the next element, the peak must be to the right
        if (nums[mid] < nums[mid + 1]) {
            return findPeakPos(nums, mid + 1, end);
        } else {
            // Otherwise, the peak is either mid or to the left
            return findPeakPos(nums, start, mid);
        }
    }
}