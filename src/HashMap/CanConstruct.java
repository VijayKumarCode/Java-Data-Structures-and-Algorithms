/**
 * Problem: 383. Ransom Note
 * Time Complexity: O(m + n)
 * Space Complexity: O(k) where k could be 1 to 26;
 */
package HashMap;
import java.util.HashMap;
import java.util.Map;
class CanConstruct {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;
        // Map to store character frequencies: Key = Character, Value = Count
        Map<Character, Integer> counts = new HashMap<>();
        // Fill the map with characters from the magazine
        for (char c : magazine.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }

        // Check against the ransomNote
        for (char c : ransomNote.toCharArray()) {
            // If the character isn't in the map or its count is 0
            if (!counts.containsKey(c) || counts.get(c) <= 0) {
                return false;
            }
            // Decrement the frequency count
            counts.put(c, counts.get(c) - 1);
        }
        //below the code without hashmap.
   /* public boolean canConstruct(String ransomNote, String magazine) {
        // Optimization: if note is longer than magazine, it's impossible
        if (ransomNote.length() > magazine.length()) return false;
        // Frequency array for lowercase English letters 'a' through 'z'
        int[] counts = new int[26];
        // Fill the "inventory" with letters available in the magazine
        for (char i : magazine.toCharArray()) {
            counts[i - 'a']++;
        }
        // Subtract letters needed for the ransomNote from the inventory
        for (char i : ransomNote.toCharArray()) {
            counts[i - 'a']--;
            // If any letter count drops below 0, the magazine lacked that letter
            if (counts[i - 'a'] < 0) {
                return false;
            }
        }*/
        return true;
    }
}