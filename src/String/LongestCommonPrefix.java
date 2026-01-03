package String;

/**
 * 🔤 LEETCODE 14: Longest Common Prefix
 * -------------------------------------
 * PROBLEM: Write a function to find the longest common prefix string amongst 
 * an array of strings. If there is no common prefix, return an empty string "".
 * * * ALGORITHM STRATEGY: Horizontal Scanning
 * 1. Initialization: Assume the first string in the array is the common prefix.
 * 2. Comparison: Iterate through the rest of the strings.
 * 3. Reduction: Use String.indexOf() to check if the current word starts with the prefix.
 * 4. Truncation: While it doesn't match, remove the last character from the prefix 
 * until a match is found or the prefix becomes empty.
 *
 * COMPLEXITY ANALYSIS:
 * - Time Complexity: O(S) -> Where S is the sum of all characters in all strings. 
 * In the worst case, we compare every character.
 * - Space Complexity: O(1) -> We only store the prefix string, no extra data 
 * structures proportional to the input size.
 */
  class LongestCommonPrefix {
   public static String longestCommonPrefix(String[] strs) {
    if (strs == null || strs.length == 0) return "";
    java.util.Arrays.sort(strs);
    String first = strs[0];
    String last = strs[strs.length - 1];
    int i = 0;
    // Only compare the first and last strings
    while (i < first.length() && i < last.length() && first.charAt(i) == last.charAt(i)) {
        i++;
    }
    return first.substring(0, i);
    }
}