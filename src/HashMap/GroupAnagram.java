/* #49. Group Anagrams
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/group-anagrams/
 * * Time Complexity: O(N * K)
 * - Where N is the number of strings and K is the max length of a string.
 * - We iterate over every string and count its characters.
 * * Space Complexity: O(N * K)
 * - To store the HashMap and the final list of groups.
 * * Approach Explained:
 * 1. Anagrams share the exact same count of every character.
 * 2. We iterate through the input array and for each string, we calculate a
 * character frequency array (size 26).
 * 3. We convert this array into a unique string key (e.g., "a1b2c0...").
 * 4. We use a HashMap where the Key is this unique pattern and the Value
 * is a list of strings matching that pattern.
 * 5. Finally, we return all the lists contained in the map values.
 */
package HashMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
class GroupAnagram{
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0) return new ArrayList<>();
        Map<String,List<String>> stringMap = new HashMap<>();
        for(String str : strs) {
            String frequencyString = getFrequency(str);
            if(stringMap.containsKey(frequencyString)) {
                stringMap.get(frequencyString).add(str);
            }
            else {
                List<String> strList = new ArrayList<>();
                strList.add(str);
                stringMap.put(frequencyString,strList);
            }
        }
        return new ArrayList<>(stringMap.values());
    }
    public String getFrequency(String str) {
        int[] frequency = new int[26];
        for(char c : str.toCharArray()) {
            frequency[c-'a']++;
        }
        StringBuilder sb = new StringBuilder(" ");
        char c = 'a';
        for(int i : frequency) {
            sb.append(c);
            sb.append(i);
            c++;
        }
        return sb.toString();
    }
}