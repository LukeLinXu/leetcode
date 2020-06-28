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
//  
// Constraints:
//
//
// 	1 <= s.length <= 7
// 	s consists only of uppercase English letters.
// 	s is between "A" and "FXSHRXW".
//
//


class Solution {
    /**
     * 直接
     */
    public int titleToNumber(String s) {
        int len = s.length();
        int count = 0;
        for(int i = len - 1; i >= 0; i--){
            int value = s.charAt(i) - 'A'+1;
            count += value*Math.pow(26, len - i - 1);
        }
        return count;
    }
}
