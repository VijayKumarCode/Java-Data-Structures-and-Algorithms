/**
 * Problem: ValidPalindrome Strings (LeetCode #125)
 * Pattern: Two Pointers (forwards)
 * * Logic: We have to find the matching under some conditions that 
 * * no special character is allowed, so we have to implement the skipping
 * * logic also.
 * * Time Complexity: $O(n)$ - We visit each element in both arrays once.
 * Space Complexity: $O(1)$ - We modify the input array in-place.
 */


class ValidPalindrome {
    public boolean isPalindrome(String s) {
        String name = "Null";
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if( s.charAt(i) >= 'a' && s.charAt(i) <= 'z'||
                s.charAt(i) >= '0' && s.charAt(i) <= '9' ){
                sb.append(s.charAt(i));
            }
        }

        name = sb.toString();
        int left = 0;
        int right = name.length()-1;

        while(left < right){
            if(name.charAt(left) != name.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
