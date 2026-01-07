/**
 * 202. Happy Number
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/happy-number/
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */
package LinkedList;
class HappyNumber {
    public boolean isHappy(int n) {
        int slow  = n;
        int fast  = n;
        do {
            slow = square(slow);
            fast = square(square(fast));
        } while(slow != fast);
        return slow == 1;
    }
    public int square(int num) {
        int answer = 0;
        while(num > 0) {
            int remainder = num % 10;
            answer += remainder * remainder;
            num /= 10;
        }
        return answer;
    }
}