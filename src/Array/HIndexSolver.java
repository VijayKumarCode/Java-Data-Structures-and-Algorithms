package Array;

/*
Problem No. #274
Difficulty: Medium
Description: H-Index
Link: https://leetcode.com/problems/h-index/
Time Complexity: O(n)
Space Complexity: O(n)
*/

 class HIndexSolver {
    public int hIndex(int[] citations) {
        int papers = citations.length;
        int[] citationBuckets = new int[papers + 1];

        for (int citation : citations) {
            citationBuckets[Math.min(citation, papers)]++;
        }

        int cumulativePapers = 0;
        for (int hIndex = papers; hIndex >= 0; hIndex--) {
            cumulativePapers += citationBuckets[hIndex];
            if (cumulativePapers >= hIndex) {
                return hIndex;
            }
        }
        return 0;
    }
}
