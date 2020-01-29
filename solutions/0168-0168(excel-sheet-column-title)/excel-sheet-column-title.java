// Given a positive integer, return its corresponding column title as appear in an Excel sheet.
//
// For example:
//
//
//     1 -> A
//     2 -> B
//     3 -> C
//     ...
//     26 -> Z
//     27 -> AA
//     28 -> AB 
//     ...
//
//
// Example 1:
//
//
// Input: 1
// Output: "A"
//
//
// Example 2:
//
//
// Input: 28
// Output: "AB"
//
//
// Example 3:
//
//
// Input: 701
// Output: "ZY"
//


class Solution {
    /**
     * 直接
     */
    public static String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n != 0){
            int k = n%26;
            sb.insert(0, convertToTitleHelper(k));
            if(k == 0){
                k = 26;
            }
            n = (n - k)/26;
        }
        return sb.toString();
    }

    public static Character convertToTitleHelper(int n) {
        if(n == 0) n = 26;
        return (char)('A'+n - 1);
    }
}
