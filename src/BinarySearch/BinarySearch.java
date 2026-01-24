package BinarySearch;

/**
 * 🔍 LEETCODE 704: Binary Search
 * ------------------------------
 * PROBLEM: Given an array of integers 'nums' sorted in ascending order, 
 * and an integer 'target', write a function to search for target in nums. 
 * If target exists, return its index. Otherwise, return -1.
 * * * ALGORITHM STRATEGY: Divide and Conquer
 * 1. Initialize: Two pointers, 'low' at the start and 'high' at the end.
 * 2. Iteration: Calculate the middle index 'mid'.
 * 3. Comparison:
 * - If nums[mid] == target: Found the element.
 * - If nums[mid] < target: Target is in the right half (low = mid + 1).
 * - If nums[mid] > target: Target is in the left half (high = mid - 1).
 *
 * COMPLEXITY ANALYSIS:
 * - Time Complexity: O(log n) -> Each step reduces the search range by half.
 * - Space Complexity: O(1) -> Performed in-place without extra structures.
 */

class BinarySearch {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while( left <= right) {
            int mid = (left + right)/2;
            if(nums[mid] == target) return mid;
            if(nums[mid] < target){
                left = mid+1;
            }
            else {
                right = mid-1;
            }
        }
        return left;
    }
}