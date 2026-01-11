package Array;

import java.util.Arrays;
/*
 * Problem No.#452.
 * Difficulty: Medium
 * Description : Minimum Number of Arrows to Burst Balloons
 * Link: https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
 * Time Complexity: O(n log n) - Due to sorting the points array.
 * Space Complexity: O(log n) - Space used by the sorting implementation.
 */

class ShotByArrow {
    public static int findMinArrowShots(int[][] points) {
         if (points == null || points.length == 0) return 0;

         Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

         int arrows = 1;
         int firstArrow = points[0][1];

         for (int i = 1; i < points.length; i++) {

              if (points[i][0] > firstArrow) {
                arrows++;
                firstArrow = points[i][1];
             }
        }
        return arrows;
   }
}