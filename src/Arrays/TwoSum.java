/**
 * Problem: Two Sum  (LeetCode #001)
 * Pattern: Two Pointers (Forwards)
 * * Logic: We have to take two pointer approach and make sure none of them call 
 * itself as it violates the question theme
 * * Time Complexity: $O(n^2)$ - We visit each element in both arrays once.
 * Space Complexity: $O(1)$ - We modify the input array in-place.
 */
class Solution {
     public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums.length; j++){
                if(i != j && nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};
    }
}
