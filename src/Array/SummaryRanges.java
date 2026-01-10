package Array;

import java.util.ArrayList;
import java.util.List;
/*
 * Problem No.#228.
 * Difficulty: Easy
 * Description : Summary Ranges
 * Link: https://leetcode.com/problems/summary-ranges/
 * Time Complexity: O(n) - We pass through the array once.
 * Space Complexity: O(1) - Excluding the space required for the output list.
 */


public class SummaryRanges {
    public static List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

            int start = nums[i];

            while (i + 1 < nums.length && nums[i + 1] == nums[i] + 1) { //skipping when difference is less than 2
                i++;
            }

            if (start == nums[i]) {
                result.add(start+"");//adding at the very start or ending of the loop.
            }

            else {
                result.add(start + "->" + nums[i]);//adding the range from start to end.
            }
        }

        return result;
    }
}