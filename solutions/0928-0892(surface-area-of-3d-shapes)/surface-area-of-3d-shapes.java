// You are given an n x n grid where you have placed some 1 x 1 x 1 cubes. Each value v = grid[i][j] represents a tower of v cubes placed on top of cell (i, j).
//
// After placing these cubes, you have decided to glue any directly adjacent cubes to each other, forming several irregular 3D shapes.
//
// Return the total surface area of the resulting shapes.
//
// Note: The bottom face of each shape counts toward its surface area.
//
//  
// Example 1:
//
//
// Input: grid = [[2]]
// Output: 10
//
//
// Example 2:
//
//
// Input: grid = [[1,2],[3,4]]
// Output: 34
//
//
// Example 3:
//
//
// Input: grid = [[1,0],[0,2]]
// Output: 16
//
//
// Example 4:
//
//
// Input: grid = [[1,1,1],[1,0,1],[1,1,1]]
// Output: 32
//
//
// Example 5:
//
//
// Input: grid = [[2,2,2],[2,1,2],[2,2,2]]
// Output: 46
//
//
//  
// Constraints:
//
//
// 	n == grid.length
// 	n == grid[i].length
// 	1 <= n <= 50
// 	0 <= grid[i][j] <= 50
//
//


class Solution {
    /**
     * 要细心啊
     */
    public static int surfaceArea(int[][] grid) {
        int count = 0;
        int bigJ = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                bigJ = Math.max(bigJ, j+1);
                int i1 = 0;
                int i2 = 0;
                try{
                    i1 = grid[i][j];
                }catch (Exception e){

                }
                try{
                    i2 = grid[i][j-1];
                }catch (Exception e){

                }
                //特别是这里
                if(i1 != 0){
                    count+=2;
                }
                if(j == 0){
                    count += Math.abs(i1);
                }else{
                    count += Math.abs(i1 - i2);
                }

                if(j == grid[i].length - 1) {
                    count += Math.abs(i1);
                }
            }
        }

        for(int j = 0; j < bigJ; j++){
            for(int i = 0; i < grid.length; i++){
                int i1 = 0;
                int i2 = 0;
                try{
                    i1 = grid[i][j];
                }catch (Exception e){

                }
                try{
                    i2 = grid[i - 1][j];
                }catch (Exception e){

                }
                if(i == 0){
                    count += Math.abs(i1);
                }else{
                    count += Math.abs(i1 - i2);
                }

                if(i == grid.length - 1) {
                    count += Math.abs(i1);
                }
            }
        }
        return count;
    }
}
