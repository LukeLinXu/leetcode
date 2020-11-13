// Given an integer n, return true if it is a power of three. Otherwise, return false.
//
// An integer n is a power of three, if there exists an integer x such that n == 3x.
//
//  
// Example 1:
// Input: n = 27
// Output: true
// Example 2:
// Input: n = 0
// Output: false
// Example 3:
// Input: n = 9
// Output: true
// Example 4:
// Input: n = 45
// Output: false
//
//  
// Constraints:
//
//
// 	-231 <= n <= 231 - 1
//
//
//  
// Follow up: Could you do it without using any loop / recursion?


public class Solution {
    public boolean isPowerOfThree(int n) {
        return (n == 1 || n == 3 || n == 9 || n == 27 || n == 81 || n == 243 || n == 729 || n == 2187 || n == 6561 || n == 19683 || n == 59049 || n == 177147 || n == 531441 || n == 1594323 || n == 4782969 || n == 14348907 || n == 43046721 || n == 129140163 || n == 387420489 || n == 1162261467);  
    }
}
