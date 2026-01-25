package BinarySearch;

/*
Problem No. #34
Difficulty: Medium
Description: Find First and Last Position of Element in Sorted Array
Link: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
Time Complexity: O(log n)
Space Complexity: O(log n)
*/

class RangeFinder {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        // Use true for finding the first occurrence, false for the last
        result[0] = binarySearch(nums, 0, nums.length - 1, target, true, -1);
        result[1] = binarySearch(nums, 0, nums.length - 1, target, false, -1);
        return result;
    }

    public int binarySearch(int[] nums, int start, int end, int tg, boolean isFirst, int bound) {
        // Base case: Search space exhausted, return the best candidate found
        if (start > end) {
            return bound;
        }

        int mid = start + (end - start) / 2;

        if (nums[mid] == tg) {
            bound = mid; // Update candidate
            if (isFirst) {
                // Look for an even earlier occurrence on the left
                return binarySearch(nums, start, mid - 1, tg, isFirst, bound);
            } else {
                // Look for an even later occurrence on the right
                return binarySearch(nums, mid + 1, end, tg, isFirst, bound);
            }
        } else {
            if (nums[mid] < tg) {
                return binarySearch(nums, mid + 1, end, tg, isFirst, bound);
            } else {
                return binarySearch(nums, start, mid - 1, tg, isFirst, bound);
            }
        }
    }
}