// Write a function that reverses a string. The input string is given as an array of characters char[].
//
// Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
//
// You may assume all the characters consist of printable ascii characters.
//
//  
//
//
// Example 1:
//
//
// Input: ["h","e","l","l","o"]
// Output: ["o","l","l","e","h"]
//
//
//
// Example 2:
//
//
// Input: ["H","a","n","n","a","h"]
// Output: ["h","a","n","n","a","H"]
//
//
//


public class Solution {
    public String reverseString(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        StringBuffer stringBuffer = new StringBuffer();
        for(int i = length - 1; i > -1; i--){
            stringBuffer.append(chars[i]);
        }
        return stringBuffer.toString();
    }
}
