package Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 🔢 LEETCODE 15: 3Sum (Unique Triplets)
 * -------------------------------------
 * PROBLEM: Find all unique triplets in the array which gives the sum of zero.
 * * ALGORITHM STRATEGY: Sort + Two Pointers
 * 1. Sort: Arrange the array to handle duplicates and use the two-pointer logic.
 * 2. Fix One, Move Two: Loop through the array, fixing one number (nums[i]).
 * 3. Two Sum II logic: For the remaining part, find two numbers that sum to (-nums[i]).
 * 4. Duplicate Management: Skip identical numbers for the fixed pointer and the 
 * two pointers to ensure all triplets in the result list are unique.
 *
 * COMPLEXITY ANALYSIS:
 * - Time Complexity: O(n²) -> Sorting takes O(n log n), nested loops take O(n²).
 * - Space Complexity: O(log n) to O(n) -> Depending on the sorting implementation.
 */
class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            if( i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int j = i+1;
            int k = nums.length-1;
            while(j < k) {
                int total  = nums[i] + nums[j] + nums[k];
                if(total > 0) {
                    k--;
                }
                else if(total < 0) {
                    j++;
                }
                else {
                    result.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;
                    while(nums[j] == nums[j-1] && j < k) {
                        j++;
                    }
                }
            }
        }
        return result;
    }
}