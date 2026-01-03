/* 🔢 LEETCODE 9: Palindrome Number
 * --------------------------------
 * PROBLEM: Determine whether an integer is a palindrome. An integer is a 
 * palindrome when it reads the same backward as forward.
 * * ALGORITHM STRATEGY: Reversing Half of the Number
 * 1. Edge Cases: Negative numbers are not palindromes (due to '-'). 
 * Numbers ending in 0 (except 0 itself) cannot be palindromes.
 * 2. Reversal: Extract the last digit using 'num % 10' and build the 
 * reversed number: 'reversed = reversed * 10 + lastDigit'.
 * 3. Stop Condition: Stop when the original number is less than or equal 
 * to the reversed half.
 * 4. Comparison: Check if 'original == reversed' (even length) or 
 * 'original == reversed / 10' (odd length).
 *
 * COMPLEXITY ANALYSIS:
 * - Time Complexity: O(log₁₀(n)) -> We divide the input by 10 every iteration.
 * - Space Complexity: O(1) -> Only a few integer variables used.
 */
  class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        int temp = x;
        int sum = 0;
        while(temp !=0) {
            int remainder = temp % 10;
            sum = sum*10 + remainder;
            temp /= 10;
        }
      
        return (sum == x);
    }
}
