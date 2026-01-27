package Stack;

import java.util.Stack;

/**
 * Problem No. #150
 * Difficulty: Medium
 * Description: Evaluate Reverse Polish Notation
 * Link: https://leetcode.com/problems/evaluate-reverse-polish-notation/
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */



class ReversePolishNotationExpressionResolver {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                // Pop the second operand first, then the first
                int second = stack.pop();
                int first = stack.pop();

                switch (token) {
                    case "+": stack.push(first + second); break;
                    case "-": stack.push(first - second); break;
                    case "*": stack.push(first * second); break;
                    case "/": stack.push(first / second); break;
                }
            } else {
                // Push the number onto the stack
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}