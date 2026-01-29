package Heap;

/*
Problem No. #215
Difficulty: Medium
Description: Kth Largest Element in an Array
Link: https://leetcode.com/problems/kth-largest-element-in-an-array/
Time Complexity: O(n log k)
Space Complexity: O(k)
*/

import java.util.PriorityQueue;

class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        // We use a Min-Heap to keep track of the 'k' largest elements.
        // The smallest of these 'k' elements stays at the top (peek).
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.add(num);

            // Once the heap size exceeds k, we remove the smallest element.
            // This ensures we only keep the largest ones seen so far.
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // The top of the heap is the k-th largest element in the original array.
        return minHeap.peek();
    }
}