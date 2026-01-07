/**
 * Problem: 205. Isomorphic Strings
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/isomorphic-strings/
 * * Time Complexity: O(N) - We iterate through the string exactly once.
 * Space Complexity: O(1) - The map size is limited by the character set (e.g., ASCII 256).
 */
package HashMap;
import java.util.HashMap;
import java.util.Map;
class Isomorphic {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;
        Map<Character, Integer> countS = new HashMap<>();
        Map<Character, Integer> countT = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);
            // Record the first index where we saw this character
            if(!countS.containsKey(charS)) {
                countS.put(charS, i);
            }
            if(!countT.containsKey(charT)) {
                countT.put(charT, i);
            }
            // Compare the "first seen" indices
            // If the patterns are isomorphic, the indices must match exactly
            if(!countS.get(charS).equals(countT.get(charT))) {
                return false;
            }
        }
        return true;
    }
}