
/**
 * Problem: Length of Last Word (LeetCode #058)
 * Topic: Strings
 * Logic: First we have to convert it into arrays  
 * and then return the length minus one length of string
 * * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        String[] sentence = s.split("\\s+");
        if(sentence.length == 1) return sentence[0].length();
        return sentence[sentence.length-1].length();
    }
}
