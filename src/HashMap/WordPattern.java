/**
 * Problem: 290. Word Pattern
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/word-pattern/
 * Time Complexity: O(M) - Where M is the number of characters in string s (due to split and iteration).
 * Space Complexity: O(M) - To store the array of words and the HashMap values.
 */
package HashMap;
import java.util.HashMap;
import java.util.Map;
class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        // Split s into individual words based on whitespace
        String[] newS = s.trim().split("\\s+");
        if(newS.length != pattern.length()) return false;
        Map<Character,String> map = new HashMap<>();
        for(int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String currentWord = newS[i];
            if(map.containsKey(c)) {
                // Case 1: Pattern character seen before.
                // Check if it maps to the EXACT SAME word as before.
                if(!map.get(c).equals(currentWord)) {
                    return false;
                }
            }
            else {
                // Case 2: New pattern character.
                // CRITICAL: Check if this word is already "taken" by another pattern character.
                if(map.containsValue(currentWord)) {
                    return false;
                }
                map.put(c, currentWord);
            }
        }
        return true;
    }
}