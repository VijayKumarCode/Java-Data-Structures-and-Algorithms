package BinarySearch;

/*
Problem No. #153
Difficulty: Medium
Description: Find Minimum in Rotated Sorted Array
Link: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
Time Complexity: O(log n)
Space Complexity: O(log n)
*/

class FindMinimumRotatedSortedArray {
    public int findMin(int[] nums) {
        return binarySearch(nums, 0, nums.length - 1);
    }

    public int binarySearch(int[] nums, int start, int end) {
        // Base case: If the range is already sorted, the minimum is at 'start'
        if (nums[start] <= nums[end]) {
            return nums[start];
        }

        int mid = start + (end - start) / 2;

        // If mid element is greater than the end element,
        // the inflection point (min) is in the right half.
        if (nums[mid] > nums[end]) {
            return binarySearch(nums, mid + 1, end);
        }
        // Otherwise, the min is in the left half, including 'mid'.
        else {
            return binarySearch(nums, start, mid);
        }
    }
}