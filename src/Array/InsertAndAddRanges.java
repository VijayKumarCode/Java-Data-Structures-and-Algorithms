package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem No.#057
 * Difficulty: Medium
 * Description : Insert Intervals
 * Link: https://leetcode.com/problems/insert-interval/
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class InsertAndAddRanges {
    private static int[][] insertNewIntervals(int[][] intervals, int[] newIntervals) {
        if (intervals.length == 0) return new int[][]{newIntervals};

        int[][] clubbed = new int[intervals.length+1][2];
        boolean inserted =false;

        for (int i = 0; i < clubbed.length; i++) {

            if(!inserted && (i == intervals.length || intervals[i][0] > newIntervals[0])) {
                clubbed[i] = newIntervals;
                inserted = true;
            }
            else {
                int indexToGo = (inserted) ? i-1 : i;//if inserted it means i need to decrement by one.
                //if not then i will be as it is.
                clubbed[i] = intervals[indexToGo];
            }
        }

        List<int[]> result = new ArrayList<>();

        for (int i = 0; i < clubbed.length; i++) {

            int start = clubbed[i][0];
            int end = clubbed[i][1];

            while (i+1 < clubbed.length && clubbed[i+1][0] <= end) {
                end = Math.max(end,clubbed[i+1][1]);
                i++;
            }
            result.add(new int[]{start,end});
        }
        return result.toArray(new int[result.size()][]);
    }
}