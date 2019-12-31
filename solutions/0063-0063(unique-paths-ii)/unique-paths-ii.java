// A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
//
// The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
//
// Now consider if some obstacles are added to the grids. How many unique paths would there be?
//
//
//
// An obstacle and empty space is marked as 1 and 0 respectively in the grid.
//
// Note: m and n will be at most 100.
//
// Example 1:
//
//
// Input:
// [
//   [0,0,0],
//   [0,1,0],
//   [0,0,0]
// ]
// Output: 2
// Explanation:
// There is one obstacle in the middle of the 3x3 grid above.
// There are two ways to reach the bottom-right corner:
// 1. Right -> Right -> Down -> Down
// 2. Down -> Down -> Right -> Right
//
//


public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if(m == 0) return 0;
        int n = obstacleGrid[0].length;
        if(n == 0) return 0;
        int [][] max = new int[m][n];
        if(obstacleGrid[0][0] == 1) return 0;
        max[0][0] = 1;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int k = obstacleGrid[i][j];
                if(k == 0){
                    if(i == 0 && j == 0){
                        
                    }else{
                        max[i][j] = ((i == 0 ? 0 : max[i - 1][j]) + (j == 0 ? 0 : max[i][j - 1]));        
                    }
                    
                }else if(k == 1){
                    max[i][j] = 0;
                }
                
            }
        }
        return max[m - 1][n - 1];
    }
    
    public int uniquePaths(int m, int n) {
        int[][] max = new int[m][n];
        for(int i = 0; i < m; i++){
            max[i][0] = 1;
        }
        for(int i = 0; i < n; i++){
            max[0][i] = 1;
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                max[i][j] = max[i - 1][j] + max[i][j - 1];
            }
        }
        return max[m - 1][n - 1];
        
    }

}
