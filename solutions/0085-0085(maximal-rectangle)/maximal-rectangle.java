// Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
//
//  
// Example 1:
//
//
// Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
// Output: 6
// Explanation: The maximal rectangle is shown in the above picture.
//
//
// Example 2:
//
//
// Input: matrix = []
// Output: 0
//
//
// Example 3:
//
//
// Input: matrix = [["0"]]
// Output: 0
//
//
// Example 4:
//
//
// Input: matrix = [["1"]]
// Output: 1
//
//
// Example 5:
//
//
// Input: matrix = [["0","0"]]
// Output: 0
//
//
//  
// Constraints:
//
//
// 	rows == matrix.length
// 	cols == matrix.length
// 	0 <= row, cols <= 200
// 	matrix[i][j] is '0' or '1'.
//
//


public class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if(m == 0) return 0;
        int n = matrix[0].length;
        int[] height = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];
        int max = 0;
        Arrays.fill(height, 0);
        Arrays.fill(left, 0);
        Arrays.fill(right, n);
        for(int i = 0; i < m; i++){
            int l = 0;
            int r = n;
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == '1'){
                    height[j] ++;
                }else{
                    height[j] = 0;
                }
            }
            
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == '1'){
                    left[j] = Math.max(left[j], l);
                }else{
                    left[j] = 0;
                    l = j + 1;
                }
            }
            
            for(int j = n - 1; j >= 0; j--){
                if(matrix[i][j] == '1'){
                    right[j] = Math.min(right[j], r);
                }else{
                    right[j] = n;
                    r = j;
                }
            }
            
            for(int j = 0; j < n; j++){
                max = Math.max(max, (right[j] - left[j])*height[j]);
            }
            
        }
        return max;
    }
}
