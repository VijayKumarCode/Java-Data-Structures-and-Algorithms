package BinarySearch;

/*
Problem No. #4
Difficulty: Hard
Description: Median of Two Sorted Arrays
Link: https://leetcode.com/problems/median-of-two-sorted-arrays/
Time Complexity: O(log(min(m, n)))
Space Complexity: O(1)
*/

public class MedianFinder {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure we binary search on the smaller array for O(log(min(m,n)))
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int n1 = nums1.length;
        int n2 = nums2.length;
        int low = 0;
        int high = n1;

        while (low <= high) {
            int cut1 = (low + high) / 2;
            int cut2 = ((n1 + n2 + 1) / 2) - cut1;

            // Boundary values around the cuts
            double L1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
            double R1 = (cut1 == n1) ? Integer.MAX_VALUE : nums1[cut1];

            double L2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
            double R2 = (cut2 == n2) ? Integer.MAX_VALUE : nums2[cut2];

            // Check if partition is correct
            if (L1 <= R2 && L2 <= R1) {
                if ((n1 + n2) % 2 == 0) {
                    return (Math.max(L1, L2) + Math.min(R1, R2)) / 2.0;
                } else {
                    return Math.max(L1, L2);
                }
            }
            // Binary search adjustment
            else if (L1 > R2) {
                high = cut1 - 1;
            } else {
                low = cut1 + 1;
            }
        }
        return 0.0;
    }
}