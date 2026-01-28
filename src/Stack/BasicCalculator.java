package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

/*
Problem No. #224
Difficulty: Hard
Description: Basic Calculator
Link: https://leetcode.com/problems/basic-calculator/
Time Complexity: $O(n)$
Space Complexity: $O(n)$
*/

class BasicCalculator {
    public int calculate(String s) {
        // Using Deque as it is more efficient than the legacy Stack class
        Deque<Integer> stack = new ArrayDeque<>();
        int result = 0;
        int num = 0;
        int sign = 1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                num = 10 * num + (c - '0');
            } else if (c == '+') {
                result += sign * num;
                num = 0;
                sign = 1;
            } else if (c == '-') {
                result += sign * num;
                num = 0;
                sign = -1;
            } else if (c == '(') {
                // Save the current result and sign before entering parentheses
                stack.push(result);
                stack.push(sign);
                // Reset context for the new sub-expression
                result = 0;
                sign = 1;
            } else if (c == ')') {
                // Finish the final calculation inside the parentheses
                result += sign * num;
                num = 0;
                // Pop sign first, then the previous result
                result *= stack.pop();
                result += stack.pop();
            }
            // Spaces are naturally ignored by the logic
        }

        // Add the final number if the string didn't end with a parenthesis
        if (num != 0) {
            result += sign * num;
        }

        return result;
    }
}
