// Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
//
//  
// Example 1:
//
//
// Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
// Output: 4
//
//
// Example 2:
//
//
// Input: matrix = [["0","1"],["1","0"]]
// Output: 1
//
//
// Example 3:
//
//
// Input: matrix = [["0"]]
// Output: 0
//
//
//  
// Constraints:
//
//
// 	m == matrix.length
// 	n == matrix[i].length
// 	1 <= m, n <= 300
// 	matrix[i][j] is '0' or '1'.
//
//


class Solution {
    /**
     * 精妙的答案，二维DP已经不容易了，还可以降到一维DP
     */
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        int[] dp = new int[cols + 1];
        int maxsqlen = 0;
        int pre = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                int temp = dp[j];
                if (matrix[i-1][j-1] == '1'){
                    dp[j] = Math.min(Math.min(dp[j - 1], pre), dp[j]) + 1;
                    maxsqlen = Math.max(maxsqlen, dp[j]);
                }else {
                    dp[j] = 0;
                }
                pre = temp;
            }
        }
        return maxsqlen * maxsqlen;
    }
}
