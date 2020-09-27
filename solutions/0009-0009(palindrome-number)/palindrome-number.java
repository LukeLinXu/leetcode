// Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
//
// Example 1:
//
//
// Input: 121
// Output: true
//
//
// Example 2:
//
//
// Input: -121
// Output: false
// Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
//
//
// Example 3:
//
//
// Input: 10
// Output: false
// Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
//
//
// Follow up:
//
// Could you solve it without converting the integer to a string?
//


public class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        String s = String.valueOf(x);
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length/2; i++){
            if(chars[i] != chars[chars.length - 1 - i]) return false;
        }
        return true;
    }
}
