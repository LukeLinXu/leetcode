// Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
//
//  
// Example 1:
//
//
// Input: grid = [
//   ["1","1","1","1","0"],
//   ["1","1","0","1","0"],
//   ["1","1","0","0","0"],
//   ["0","0","0","0","0"]
// ]
// Output: 1
//
//
// Example 2:
//
//
// Input: grid = [
//   ["1","1","0","0","0"],
//   ["1","1","0","0","0"],
//   ["0","0","1","0","0"],
//   ["0","0","0","1","1"]
// ]
// Output: 3
//
//


class Solution {
    /**
     * 直接
     */
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                char pick = grid[i][j];
                if(pick == '1'){
                    count++;
                    grid[i][j] = '2';
                    numIslandsHelper(grid, i, j);
                }
            }
        }
        return count;
    }

    public void numIslandsHelper(char[][] grid, int i, int j) {
        if(i+1 < grid.length && grid[i+1][j] == '1'){
            grid[i+1][j] = '2';
            numIslandsHelper(grid, i+1, j);
        }
        if(i-1 >= 0 && grid[i-1][j] == '1'){
            grid[i-1][j] = '2';
            numIslandsHelper(grid, i-1, j);
        }
        if(j+1 < grid[i].length && grid[i][j+1] == '1'){
            grid[i][j+1] = '2';
            numIslandsHelper(grid, i, j+1);
        }
        if(j-1 >= 0 && grid[i][j-1] == '1'){
            grid[i][j-1] = '2';
            numIslandsHelper(grid, i, j-1);
        }
    }
}
