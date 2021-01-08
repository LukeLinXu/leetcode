// Given a triangle array, return the minimum path sum from top to bottom.
//
// For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.
//
//  
// Example 1:
//
//
// Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
// Output: 11
// Explanation: The triangle looks like:
//    2
//   3 4
//  6 5 7
// 4 1 8 3
// The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
//
//
// Example 2:
//
//
// Input: triangle = [[-10]]
// Output: -10
//
//
//  
// Constraints:
//
//
// 	1 <= triangle.length <= 200
// 	triangle[0].length == 1
// 	triangle[i].length == triangle[i - 1].length + 1
// 	-104 <= triangle[i][j] <= 104
//
//
//  
// Follow up: Could you do this using only O(n) extra space, where n is the total number of rows in the triangle?


public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int length = triangle.size();
        if(length == 0) return 0;
        int[][] minMatrix = new int[length][length];
        minMatrix[0][0] = triangle.get(0).get(0);
        if(length == 1) return minMatrix[0][0];
        
        int min = 0;
        for(int i = 1; i < length; i++){
            for(int j = 0; j <= i; j++){
                int n = triangle.get(i).get(j);
                if(j == 0){
                    minMatrix[i][j] = minMatrix[i - 1][j] + n;
                }else if(j == i){
                    minMatrix[i][j] = minMatrix[i - 1][j - 1] + n;
                }else{
                    minMatrix[i][j] = Math.min(minMatrix[i - 1][j - 1], minMatrix[i - 1][j]) + n;
                }
                if(i == length - 1){
                    if(j == 0){
                        min = minMatrix[i][j];  
                    }else{
                        min = Math.min(min, minMatrix[i][j]);
                    } 
                }
            }
        }
        return min;
        
    }
}
