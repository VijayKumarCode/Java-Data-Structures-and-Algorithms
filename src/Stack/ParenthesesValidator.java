package Stack;

import java.util.Stack;
/*
Problem No. #20
Difficulty: Easy
Description: Valid Parentheses
Link: https://leetcode.com/problems/valid-parentheses/
Time Complexity: O(n)
Space Complexity: O(n)
*/


public class ParenthesesValidator {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()) {
            if(c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            else {
                // Fail immediately if we have a closing bracket but stack is empty
                if(stack.isEmpty()) {
                    return false;
                }

                char top = stack.peek();
                if(isMatching(top, c)) {
                    stack.pop(); // Match found, remove from stack
                }
                else {
                    return false; // Mismatch found
                }
            }
        }
        // If stack is empty, all brackets were matched correctly
        return stack.isEmpty();
    }

    private boolean isMatching(char top, char close) {
        if(top == '(' && close == ')') return true;
        if(top == '[' && close == ']') return true;
        if(top == '{' && close == '}') return true;
        return false;
    }
}
