package HashMap;
import java.util.HashSet;
/*
 * Problem: 219. Contains Duplicate II
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/contains-duplicate-ii/
 * Time Complexity: O(n)
 * Space Complexity: O(min(n, k))
 */

class ContainsDuplicate2 {
private static boolean containDuplicate(int[] nums, int k) {
    // A HashSet to store elements in the current window of size k
    HashSet<Integer> set = new HashSet<>();

    for (int i = 0; i < nums.length; i++) {
        // If the current element is already in the set,
        // it means we found a duplicate within distance k
        if (set.contains(nums[i])) {
            return true;
        }

        // Add current element to the set
        set.add(nums[i]);

        // If the set size exceeds k, remove the oldest element (at index i - k)
        // This maintains the "sliding window" of size k
            if (set.size() > k) {
            set.remove(nums[i - k]);
           }
       }
        return false;
   }
}