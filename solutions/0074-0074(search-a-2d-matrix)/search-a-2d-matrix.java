// Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
//
//
// 	Integers in each row are sorted from left to right.
// 	The first integer of each row is greater than the last integer of the previous row.
//
//
//  
// Example 1:
//
//
// Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 3
// Output: true
//
//
// Example 2:
//
//
// Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 13
// Output: false
//
//
// Example 3:
//
//
// Input: matrix = [], target = 0
// Output: false
//
//
//  
// Constraints:
//
//
// 	m == matrix.length
// 	n == matrix[i].length
// 	0 <= m, n <= 100
// 	-104 <= matrix[i][j], target <= 104
//
//


public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int len0 = matrix.length;
        if(len0 == 0) return false;
        int len1 = matrix[0].length;
        if(len1 == 0) return false;
        if(target < matrix[0][0] || target > matrix[len0-1][len1-1]) return false;
        if(target >= matrix[len0-1][0]) return searchMM(matrix[len0-1], target);
        if(target <= matrix[0][len1-1]) return searchMM(matrix[0], target);
        int l = 0;
        int r = len0-1;
        while(l<r){
            int m = (l+r)/2;
            if(m == l) break;
            if(matrix[m][0] > target){
                r = m;
            }else if(matrix[m][0] < target){
                l = m;
            }else{
                return true;
            }
        }
        
        return searchMM(matrix[l], target);
    }
    
    public boolean searchMM(int[] matrix, int target){
        int len = matrix.length;
        if(len == 1) return matrix[0] == target;
        int l = 0;
        int r = len - 1;
        while(l < r){
            if (r - l == 1){
                return matrix[l] == target || matrix[r] == target;
            }else{
                int m = (l + r)/2;
                if(matrix[m] > target){
                    r = m;
                }else if(matrix[m] < target){
                    l = m;
                }else{
                    return true;
                }
            }
        }
        return false;
    }
}
