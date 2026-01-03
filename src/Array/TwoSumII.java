package Array;

/**
 * 🔢 LEETCODE 167: Two Sum II - Input Array Is Sorted
 * --------------------------------------------------
 * PROBLEM: Find two numbers such that they add up to a specific target number.
 * * ALGORITHM STRATEGY: Two Pointers
 * 1. Initialize: One pointer at the start (left) and one at the end (right).
 * 2. Iteration: 
 * - If sum == target: Return indices (1-indexed).
 * - If sum < target: Move the left pointer forward (to increase sum).
 * - If sum > target: Move the right pointer backward (to decrease sum).
 *
 * COMPLEXITY ANALYSIS:
 * - Time Complexity: O(n) -> We traverse the array at most once.
 * - Space Complexity: O(1) -> No extra data structures used.
 */
class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length-1;
        while(i < j) {
            if(numbers[i] + numbers[j] < target) {
                i++;
            }
            else if(numbers[i] + numbers[j] > target) {
                j--;
            }
            else {
                return new int[]{++i, ++j};
            }
        }
        return new int[]{-1,-1};
    }
}