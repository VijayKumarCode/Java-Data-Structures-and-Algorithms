package String;
/**
 * 📝 LEETCODE 151: Reverse Words in a String
 * -----------------------------------------
 * PROBLEM: Given an input string s, reverse the order of the words.
 * * CONSTRAINTS:
 * - The input string may contain leading or trailing spaces.
 * - Words are separated by at least one space.
 * - The returned string should only have a single space separating the words.
 * ALGORITHM
 *          STRATEGY 1
 * 1. Trim leading/trailing whitespace.
 * 2. Split the string into a list of words using a Regex (\\s+).
 * 3. Reverse the list of words using a Two-Pointer approach.
 * 4. Join the words back into a single string with spaces.
 *        STRATEGY 2
 * 1. Trim leading/trailing whitespace.
 * 2. Split the string into a list of words using a Regex (\\s+).
 * 3. Add each one by one  from last to till the zero index.
 * 4. return after adding into one.
 * 5. ok
 * COMPLEXITY ANALYSIS:
 * - Time Complexity: O(n) -> We traverse the string and the resulting word list.
 * - Space Complexity: O(n) -> Storing the split words in an array/list.
 */
class ReverseWordsInString {
    public String reverseWords(String s) {
        String[] revSentence = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
       /* for(int  i = revSentence.length-1; i >=0; i--){
            sb.append(revSentence[i]);
                sb.append(" ");
            }
        }
        return sb.toString().trim();
        */
        String temp = "Null";
        int left = 0;
        int right = revSentence.length-1;
        while(left < right){
            temp = revSentence[left];
            revSentence[left] = revSentence[right];
            revSentence[right] = temp;
            left++;
            right--;
        }
        for(String words : revSentence){
            if(!words.isEmpty()){
                if(sb.length() > 0){
                    sb.append(" ");
                }
            }
            sb.append(words);
        }
        return sb.toString();
    }
}