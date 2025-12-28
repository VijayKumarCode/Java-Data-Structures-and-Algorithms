/**
 * LEETCODE Problem #28: Find the Index of the First Occurrence in a String
 * * Finds the index of the first occurrence of needle in haystack, 
 * or -1 if needle is not part of haystack.
 * @param haystack The main string to search within.
 * @param needle   The substring to search for.
 * @return The starting index of the needle, or -1 if not found.
 */
class FirstOccurrence {
    public int strStr(String haystack, String needle) {
        if(haystack.length() < needle.length()) return -1;
        for(int i = 0; i <= haystack.length()-needle.length(); i++) {
            int j = 0;
            while(j < needle.length() && haystack.charAt(i+j) == needle.charAt(j)) {
                j++;
                if(j == needle.length()) {
                    return i;
                }
            }
        }
        return -1;
    }
}
