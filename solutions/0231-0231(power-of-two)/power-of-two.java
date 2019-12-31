// Given an integer, write a function to determine if it is a power of two.
//
// Example 1:
//
//
// Input: 1
// Output: true 
// Explanation: 20 = 1
//
//
// Example 2:
//
//
// Input: 16
// Output: true
// Explanation: 24 = 16
//
// Example 3:
//
//
// Input: 218
// Output: false
//


public class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0) return false;
        String s = Integer.toBinaryString(n);
        char[] chars = s.toCharArray();
        if(chars[0] != '1') return false;
        for(int i = 1; i < chars.length; i++){
            if(chars[i] != '0') return false;
        }
        return true;
    }
}
