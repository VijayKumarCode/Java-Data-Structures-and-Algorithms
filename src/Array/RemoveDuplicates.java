package Array;
/**
 * Problem: Remove Duplicates (LeetCode #080)
 * Pattern: Two Pointers (Read/Write)
 * * Logic: comparing adjacent two pointers simaltaneously
 * * inorder to eliminate thrice appearence of any number in the array
 * * Time Complexity: $O(N)$ - Single pass through the array.
 * Space Complexity: $O(1)$ - No extra space used.
 */
class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int currentIndex = 1;
        int counter = 0;
        int prevValue = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != prevValue) {
                counter = 0;
            }
            else {
                counter++;
            }
            if(counter <= 1) {
                nums[currentIndex++] = nums[i];
                prevValue = nums[i];
            }
        }
        return currentIndex;//return the list of an array under thrice appeareance is prohibited
    }
}