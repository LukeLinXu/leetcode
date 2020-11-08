// Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
//
// Note: You can only move either down or right at any point in time.
//
//  
// Example 1:
//
//
// Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
// Output: 7
// Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
//
//
// Example 2:
//
//
// Input: grid = [[1,2,3],[4,5,6]]
// Output: 12
//
//
//  
// Constraints:
//
//
// 	m == grid.length
// 	n == grid[i].length
// 	1 <= m, n <= 200
// 	0 <= grid[i][j] <= 100
//
//


public class Solution {
    public int minPathSum(int[][] grid) {
        int xLength = grid.length;
        if(xLength == 0) return 0;
        int yLength = grid[0].length;
        int[][] minSum = new int[xLength][yLength];
        for(int i = 0; i < xLength; i++){
            for(int j = 0; j < yLength; j++){
                if(i == 0 && j == 0){
                    minSum[i][j] = grid[i][j];
                }else if(i == 0){
                    minSum[i][j] = grid[i][j] + minSum[i][j-1];
                }else if(j == 0){
                    minSum[i][j] = grid[i][j] + minSum[i-1][j];
                }else{
                    minSum[i][j] = grid[i][j] + Math.min(minSum[i][j-1],minSum[i-1][j]);
                }
            }
        }
        return minSum[xLength-1][yLength-1];
    }
    

}
