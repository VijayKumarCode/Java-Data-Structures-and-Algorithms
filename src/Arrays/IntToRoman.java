/**
 * 🔢 LEETCODE 12: Integer to Roman
 * --------------------------------
 * PROBLEM: Convert an integer to a Roman numeral.
 * * ALGORITHM STRATEGY: Greedy Algorithm
 * 1. Mapping: Create an array of values and corresponding Roman symbols 
 * including subtractive cases (CM, CD, XC, XL, IX, IV).
 * 2. Iteration: Loop through the values starting from the largest (1000).
 * 3. Extraction: Use a while loop to append the symbol and subtract the 
 * value until the current value is larger than the remaining number.
 *
 * COMPLEXITY ANALYSIS:
 * - Time Complexity: O(1) -> Although there is a loop, the number of 
 * symbols is fixed (max 13), and the input range is limited to 3999.
 * - Space Complexity: O(1) -> We use a constant amount of space for the mapping.
 */
class IntToRoman {
    private static String intToRoman(int number) {
        StringBuilder sb = new StringBuilder();
        int[] values = {1000,900,500,400,100,90,50,40,10,5,1};
        String[] values2 = {"M","CM","D","CD","C","XC","L","XL","X","V","I"};
        for (int i = 0; i < values.length; i++) {
            while (number >= values[i]) {
                    number -= values[i];
                    sb.append(values2[i]);
            }
        }
        return sb.toString();
    }
}
