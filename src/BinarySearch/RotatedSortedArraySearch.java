package BinarySearch;

/*
Problem No. #33
Difficulty: Medium
Description: Search in Rotated Sorted Array
Link: https://leetcode.com/problems/search-in-rotated-sorted-array/
Time Complexity: O(log n)
Space Complexity: O(log n)
*/

class RotatedSortedArraySearch {
    public int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    public int binarySearch(int[] nums, int start, int end, int tg) {
        // Base case: If start exceeds end, the target is not in the array
        if (start > end) {
            return -1;
        }

        int mid = start + (end - start) / 2;

        if (nums[mid] == tg) {
            return mid;
        }

        // Logic: In a rotated array, at least one half (left or right) MUST be sorted.

        // Check if the left half [start...mid] is sorted
        if (nums[start] <= nums[mid]) {
            // If target lies within the sorted left range
            if (nums[start] <= tg && tg < nums[mid]) {
                return binarySearch(nums, start, mid - 1, tg);
            } else {
                // Otherwise, target must be in the right half
                return binarySearch(nums, mid + 1, end, tg);
            }
        }
        // Otherwise, the right half [mid...end] must be sorted
        else {
            // If target lies within the sorted right range
            if (nums[mid] < tg && tg <= nums[end]) {
                return binarySearch(nums, mid + 1, end, tg);
            } else {
                // Otherwise, target must be in the left half
                return binarySearch(nums, start, mid - 1, tg);
            }
        }
    }
}
