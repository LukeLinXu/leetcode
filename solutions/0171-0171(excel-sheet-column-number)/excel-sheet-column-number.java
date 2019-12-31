// Given a column title as appear in an Excel sheet, return its corresponding column number.
//
// For example:
//
//
//     A -> 1
//     B -> 2
//     C -> 3
//     ...
//     Z -> 26
//     AA -> 27
//     AB -> 28 
//     ...
//
//
// Example 1:
//
//
// Input: "A"
// Output: 1
//
//
// Example 2:
//
//
// Input: "AB"
// Output: 28
//
//
// Example 3:
//
//
// Input: "ZY"
// Output: 701
//


public class Solution {
    public int titleToNumber(String s) {
        int num = 0;
        int off = 'A' - 1;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(s.length() - 1 - i);
            num += (c - off) * (Math.pow(26, i));
        }
        return num;
    }
}
