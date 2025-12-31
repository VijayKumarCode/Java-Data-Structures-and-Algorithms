/**
 * Problem 13: Roman to Integer
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/roman-to-integer/
 * * Description:
 * Given a roman numeral, convert it to an integer.
 * * Time Complexity: O(n) - We traverse the string exactly once.
 * Space Complexity: O(1) - We only store a few integer variables regardless of input size.
 */
class RomanToInt {
   public int romanToInt(String s) {
       int output = 0;
       int prevValue = 0;

    // Moving backwards through the string makes the subtraction logic easier
      for (int i = s.length() - 1; i >= 0; i--) {
          int currentValue = 0;
           switch (s.charAt(i)) {
               case 'I': currentValue = 1; break;
               case 'V': currentValue = 5; break;
               case 'X': currentValue = 10; break;
               case 'L': currentValue = 50; break;
               case 'C': currentValue = 100; break;
               case 'D': currentValue = 500; break;
               case 'M': currentValue = 1000; break;
            }

        // If the current value is smaller than the value to its right, subtract it
             if (currentValue < prevValue) {
              output -= currentValue;
            } 
            else {
              output += currentValue;
            }
        
          prevValue = currentValue;
        }
    
       return output;
    }
}


