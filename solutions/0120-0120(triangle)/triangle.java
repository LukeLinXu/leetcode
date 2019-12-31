// Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
//
// For example, given the following triangle
//
//
// [
//      [2],
//     [3,4],
//    [6,5,7],
//   [4,1,8,3]
// ]
//
//
// The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
//
// Note:
//
// Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
//


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
