// A 3 x 3 magic square is a 3 x 3 grid filled with distinct numbers from 1 to 9 such that each row, column, and both diagonals all have the same sum.
//
// Given a row x col grid of integers, how many 3 x 3 "magic square" subgrids are there?  (Each subgrid is contiguous).
//
//  
// Example 1:
//
//
// Input: grid = [[4,3,8,4],[9,5,1,9],[2,7,6,2]]
// Output: 1
// Explanation: 
// The following subgrid is a 3 x 3 magic square:
//
// while this one is not:
//
// In total, there is only one magic square inside the given grid.
//
//
// Example 2:
//
//
// Input: grid = [[8]]
// Output: 0
//
//
// Example 3:
//
//
// Input: grid = [[4,4],[3,3]]
// Output: 0
//
//
// Example 4:
//
//
// Input: grid = [[4,7,8],[9,5,1],[2,3,6]]
// Output: 0
//
//
//  
// Constraints:
//
//
// 	row == grid.length
// 	col == grid[i].length
// 	1 <= row, col <= 10
// 	0 <= grid[i][j] <= 15
//
//


class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for(int i = 0; i< m; i++){
            for(int j = 0;j < n; j++){
                if(checkMagic(grid, i, j)){
                    count++;
                }
            }
        }
        return count;
    }

    public boolean checkMagic(int[][] grid, int x, int y) {
        int m = grid.length;
        int n = grid[0].length;
        if(x > m-3) return false;
        if(y > n-3) return false;
        int temp = grid[x][y];
        for(int i = x; i< x+3; i++){
            for(int j = y;j < y+3; j++){
                if(grid[i][j] > 9|| grid[i][j] < 1){
                    return false;
                }
                if(i != x && j!= y){
                    if(grid[i][j] == temp){
                        return false;
                    }
                }
            }
        }
        
        int sum1 = grid[x][y] + grid[x+1][y] + grid[x+2][y];
        int sum2 = grid[x][y+1] + grid[x+1][y+1] + grid[x+2][y+1];
        if(sum1 != sum2) return false;
        int sum3 = grid[x][y+2] + grid[x+1][y+2] + grid[x+2][y+2];
        if(sum1 != sum3) return false;
        int sum4 = grid[x][y] + grid[x][y+1] + grid[x][y+2];
        if(sum1 != sum4) return false;
        int sum5 = grid[x+1][y] + grid[x+1][y+1] + grid[x+1][y+2];
        if(sum1 != sum5) return false;
        int sum6 = grid[x+2][y] + grid[x+2][y+1] + grid[x+2][y+2];
        if(sum1 != sum6) return false;
        int sum7 = grid[x][y] + grid[x+1][y+1] + grid[x+2][y+2];
        if(sum1 != sum7) return false;
        int sum8 = grid[x][y+2] + grid[x+1][y+1] + grid[x+2][y];
        if(sum1 != sum8) return false;
        return true;
    }
}
