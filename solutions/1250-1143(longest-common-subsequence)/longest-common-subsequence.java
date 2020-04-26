// Given two strings text1 and text2, return the length of their longest common subsequence.
//
// A subsequence of a string is a new string generated from the original string with some characters(can be none) deleted without changing the relative order of the remaining characters. (eg, "ace" is a subsequence of "abcde" while "aec" is not). A common subsequence of two strings is a subsequence that is common to both strings.
//
//  
//
// If there is no common subsequence, return 0.
//
//  
// Example 1:
//
//
// Input: text1 = "abcde", text2 = "ace" 
// Output: 3  
// Explanation: The longest common subsequence is "ace" and its length is 3.
//
//
// Example 2:
//
//
// Input: text1 = "abc", text2 = "abc"
// Output: 3
// Explanation: The longest common subsequence is "abc" and its length is 3.
//
//
// Example 3:
//
//
// Input: text1 = "abc", text2 = "def"
// Output: 0
// Explanation: There is no such common subsequence, so the result is 0.
//
//
//  
// Constraints:
//
//
// 	1 <= text1.length <= 1000
// 	1 <= text2.length <= 1000
// 	The input strings consist of lowercase English characters only.
//
//


class Solution {
    /**
     * 虽然是自己做的，也是看了hint...使用了二维数组来解决，挺好的方法
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] dp = new int[len1+1][len2+1];
        for(int i1 = 0; i1 < len1; i1++){
            for(int i2 = 0; i2 < len2; i2++){
                if(text1.charAt(i1) == text2.charAt(i2)){
                    dp[i1+1][i2+1] = dp[i1][i2]+1;
                }else {
                    dp[i1+1][i2+1] = Math.max(dp[i1][i2+1], dp[i1+1][i2]);
                }
            }
        }
        return dp[len1][len2];
    }
}
