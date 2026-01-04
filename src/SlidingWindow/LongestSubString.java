package SlidingWindow;
/**
 * Problem: Longest Substring Without Repeating Characters
 * Goal: Find the length of the longest substring without repeating characters.
 * Strategy: Sliding Window (Two Pointers) with a HashSet
 * Time Complexity: O(n) - Each character is visited at most twice.
 * Space Complexity: O(min(m, n)) - Space for the set, where m is the alphabet size.
 */
class LongestSubString {
    public int lengthOfLongestSubstring(String s) {
        String longest = "";
        int left = 0;
        java.util.Set<Character> seen = new java.util.HashSet<>();

        for (int right = 0; right < s.length(); right++) {
            // If we find a duplicate, shrink the window from the left
            while (seen.contains(s.charAt(right))) {
                seen.remove(s.charAt(left));
                left++;
            }
            // Add current character and update the longest substring found
            seen.add(s.charAt(right));
            if (right - left + 1 > longest.length()) {
                longest = s.substring(left, right + 1);
            }
        }
        return longest.length();
    }
}