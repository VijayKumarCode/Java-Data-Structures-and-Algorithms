package Stack;

import java.util.ArrayList;
import java.util.List;

/*
Problem No. #155
Difficulty: Medium
Description: Min Stack
Link: https://leetcode.com/problems/min-stack/
Time Complexity: O(1)
Space Complexity: O(n)
*/

class MinStack {
    private List<int[]> st;

    public MinStack() {
        st = new ArrayList<>();
    }

    public void push(int val) {
        int min;
        if (st.isEmpty()) {
            min = val;
        } else {
            // Get the current minimum from the top of the stack
            int currentMin = st.get(st.size() - 1)[1];
            min = Math.min(currentMin, val);
        }
        // Store [value, current_minimum]
        st.add(new int[]{val, min});
    }

    public void pop() {
        if (!st.isEmpty()) {
            st.remove(st.size() - 1);
        }
    }

    public int top() {
        if (!st.isEmpty()) {
            // Return the value (index 0)
            return st.get(st.size() - 1)[0];
        }
        else {
            return -1;
        }// Ideally throw EmptyStackException here
    }

    public int getMin() {
        if (!st.isEmpty()) {
            // Return the minimum (index 1)
            return st.get(st.size() - 1)[1];
        }
        else {
            return -1; // Ideally throw EmptyStackException here
        }
    }
}
