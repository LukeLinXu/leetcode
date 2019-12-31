// Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
//
// Example 1:
//
//
// Input: 16
// Output: true
//
//
//
// Example 2:
//
//
// Input: 5
// Output: false
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
