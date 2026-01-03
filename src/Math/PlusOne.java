package Math;
/**
 * 🔢 LEETCODE 66: Plus One
 * ------------------------
 * PROBLEM: Given a large integer represented as an integer array 'digits', 
 * increment the large integer by one and return the resulting array.
 * * ALGORITHM STRATEGY: Schoolbook Addition (Carry-over)
 * 1. Traverse: Loop from the end of the array to the beginning.
 * 2. Logic: If digit < 9, increment and return immediately.
 * 3. Carry: If digit is 9, set to 0 and move to the next left digit.
 * 4. Edge Case: If all digits were 9, create a new array of size n+1 
 * and set the first element to 1.
 * COMPLEXITY ANALYSIS:
 * - Time Complexity: O(n) -> Single pass through the digits.
 * - Space Complexity: O(n) -> Only in the worst case (all 9s) where we create a new array.
 */
class PlusOne {
    public int[] plusOne(int[] digits) {
       for(int i = digits.length-1; i >=0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
              return digits;
            }
            else {
                digits[i] = 0;
            }
        } 
        int[] newNumber = new int[digits.length+1];
        newNumber[0] = 1;
        return newNumber; 
    }
}