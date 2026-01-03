package Array;
/**
 * Problem: Remove Element (LeetCode #27)
 * Pattern: Two Pointers (Read/Write)
 * * Logic: Use a 'write' pointer to track where the next non-target 
 * element should go. Iterate with a 'read' pointer.
 * * Time Complexity: $O(N)$ - Single pass through the array.
 * Space Complexity: $O(1)$ - No extra space used.
 */
class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int k = 0; // The write pointer
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}