package BitManupulation;

/**
 * Problem No. #67
 * Difficulty: Easy
 * Description: Add Binary
 * Link: https://leetcode.com/problems/add-binary/
 * Time Complexity: O(max(N, M))
 * Space Complexity: O(max(N, M))
 */

class BinaryAdder {
    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();

        while (i >= 0 || j >= 0 || carry != 0) {
            int sum = carry;

            if (i >= 0) {
                sum += a.charAt(i--) - '0';
            }
            if (j >= 0) {
                sum += b.charAt(j--) - '0';
            }

            // sum % 2 extracts the binary digit for the current position
            sb.append(sum % 2);
            // sum / 2 extracts the carry (1 if sum is 2 or 3, else 0)
            carry = sum / 2;
        }
        // Reverse since we appended from the least significant bit
        return sb.reverse().toString();
    }
}
