package Math;

/**
 Problem No. #149
 Difficulty: Hard
 Description: Max Points on a Line
 Link: https://leetcode.com/problems/max-points-on-a-line/
 Time Complexity: O(n^2)
 Space Complexity: O(n)
 */

import java.util.HashMap;
import java.util.Map;

public class MaxPoints {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2) return n;

        // We start with 1 because any single point is a line of 1
        int max = 1;

        for (int i = 0; i < n; i++) {
            Map<String, Integer> slopeMap = new HashMap<>();

            for (int j = i + 1; j < n; j++) {
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];

                // Normalizing the slope using GCD
                int common = gcd(dx, dy);

                // Constructing a unique string key for the slope
                String slope = (dx / common) + "_" + (dy / common);

                slopeMap.put(slope, slopeMap.getOrDefault(slope, 0) + 1);
            }

            for (int count : slopeMap.values()) {
                // Neighbors + the current point 'i'
                max = Math.max(max, count + 1);
            }
        }
        return max;
    }

    // Euclidean Algorithm to find the Greatest Common Divisor
    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}