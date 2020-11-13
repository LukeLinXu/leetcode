// Given an integer n, return true if it is a power of four. Otherwise, return false.
//
// An integer n is a power of four, if there exists an integer x such that n == 4x.
//
//  
// Example 1:
// Input: n = 16
// Output: true
// Example 2:
// Input: n = 5
// Output: false
// Example 3:
// Input: n = 1
// Output: true
//
//  
// Constraints:
//
//
// 	-231 <= n <= 231 - 1
//
//
//  
// Follow up: Could you solve it without loops/recursion?


public class Solution {
    public boolean isPowerOfFour(int num) {
        if(num < 0) return false;
        String s = Integer.toBinaryString(num);
        if(s.length() % 2 == 0) return false;
        if(s.charAt(0) == '0') return false;
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == '1') return false;
        }
        return true;
    }
}
