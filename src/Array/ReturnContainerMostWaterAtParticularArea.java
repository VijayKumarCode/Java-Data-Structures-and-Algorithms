/**
 * Problem No.#11: Container With Most Water
 * Difficulty: Medium
 * Description: Find two lines that together with the x-axis forms a container,
 * such that the container contains the most water.
 * * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
package Array;
class ReturnContainerMostWaterAtParticularArea {
    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int currentHeight = 0;
        int maxArea = 0;

        while (left < right) {
            int width = right - left;

            // Determine the height based on the shorter bar
            currentHeight = (height[left] < height[right]) ? height[left] : height[right];

            int currentArea = currentHeight * width;
            maxArea = (currentArea > maxArea) ? currentArea : maxArea;

            // Move the pointer of the shorter bar to find a potentially taller one
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}