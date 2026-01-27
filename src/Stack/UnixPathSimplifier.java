package Stack;

import java.util.Stack;

/*
Problem No. #71
Difficulty: Medium
Description: Simplify Path
Link: https://leetcode.com/problems/simplify-path/
Time Complexity: O(n)
Space Complexity: O(n)
*/


public class UnixPathSimplifier {
    public String simplifyPath(String path) {
        // Corrected the type from Character to String
        Stack<String> stack = new Stack<>();
        String[] unixStyle = path.split("/");

        for (String segment : unixStyle) {
            // "." means stay here, empty means there were extra slashes "//"
            if (segment.equals(".") || segment.isEmpty()) {
                continue;
            }
            // ".." means go up one level (pop from stack)
            else if (segment.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
            // Valid directory name, push to stack
            else {
                stack.push(segment);
            }
        }

        // If nothing is left, we are at the root
        if (stack.isEmpty()) {
            return "/";
        }

        StringBuilder sb = new StringBuilder();
        // In Java, iterating over a Stack goes from bottom to top
        for (String st : stack) {
            sb.append("/").append(st);
        }

        return sb.toString();
    }
}