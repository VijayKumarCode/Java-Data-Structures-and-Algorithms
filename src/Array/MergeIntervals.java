package Array;
import java.util.*;
/*
 * 56. Merge Intervals
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/merge-intervals/
 * Time Complexity: O(n log n) - Sorting takes the most time.
 * Space Complexity: O(log n) - Space used by the sorting algorithm.
 */


public class MergeIntervals{
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;

        // 1. Sort based on start times
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            // 2. Look ahead: as long as the next interval starts
            // before or exactly when the current one ends
            while (i + 1 < intervals.length && intervals[i + 1][0] <= end) {
                // Update 'end' to be the max of current end and the NEXT interval's end
                end = Math.max(end, intervals[i + 1][1]);
                i++; // Move to the next interval to check it in the next loop iteration
            }

            result.add(new int[]{start, end});
        }

        return result.toArray(new int[result.size()][]);
    }
}