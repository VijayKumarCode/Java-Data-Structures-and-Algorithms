/*
 * Problem 30: Substring with Concatenation of All Words
 * Link: https://leetcode.com/problems/substring-with-concatenation-of-all-words/
 * * Approach: Sliding Window with Offsets
 * - Since all words have the same length (wordlen), we iterate through all possible
 * starting offsets (0 to wordlen-1).
 * - For each offset, we slide a window and maintain a frequency map of words found.
 * - Time Complexity: O(N), where N is the length of string s.
 * - Space Complexity: O(M), where M is the total characters in the words array.
 */
package SlidingWindow;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
class FindAllSubStringCombination {
    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};
        System.out.println(findSubstring(s, words));
    }
    public static List<Integer> findSubstring(String s, String[] words) {
        // Guard clause for edge cases
        if (s == null || words == null || words.length == 0 ||
                words[0].length() * words.length > s.length()) {
            return new ArrayList<>();
        }
        Map<String, Integer> word_frq = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        // 1. Store the frequency of every word in words[]
        for (String str : words) {
            word_frq.put(str, word_frq.getOrDefault(str, 0) + 1);
        }
        int wordlen = words[0].length();
        int totalWords = words.length;
        // Use an array to store substrings to avoid re-calculating s.substring repeatedly
        String[] str = new String[s.length()];
        // 2. Loop through offsets to cover all potential alignments
        for (int i = 0; i < wordlen; i++) {
            Map<String, Integer> frq = new HashMap<>();
            int begin = i; // Starting index of the current window
            int size = 0;  // Number of valid words currently in the window
            for (int j = i; j <= s.length() - wordlen; j += wordlen) {
                str[j] = s.substring(j, j + wordlen);
                if (word_frq.containsKey(str[j])) {
                    // Start the window if it was previously reset
                    if (begin == -1) begin = j;
                    frq.put(str[j], frq.getOrDefault(str[j], 0) + 1);
                    size++;
                    // 3. If window size matches target, check and slide
                    if (size == totalWords) {
                        if (frq.equals(word_frq)) {
                            ans.add(begin);
                        }
                        // Slide the window by removing the word at the 'begin' index
                        String leftWord = str[begin];
                        frq.put(leftWord, frq.get(leftWord) - 1);
                        begin += wordlen;
                        size--;
                    }
                } else {
                    // 4. Invalid word encountered: Reset window
                    begin = -1;
                    size = 0;
                    frq.clear();
                }
            }
        }
        return ans;
    }
}