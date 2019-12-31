// Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
//
// Example 1:
//
//
// Input:
// [
//  [ 1, 2, 3 ],
//  [ 4, 5, 6 ],
//  [ 7, 8, 9 ]
// ]
// Output: [1,2,3,6,9,8,7,4,5]
//
//
// Example 2:
//
// Input:
// [
//   [1, 2, 3, 4],
//   [5, 6, 7, 8],
//   [9,10,11,12]
// ]
// Output: [1,2,3,4,8,12,11,10,9,5,6,7]
//


public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        int m = matrix.length;
        if(m == 0) return list;
        int n = matrix[0].length;
        if(n == 0) return list;
        int x = 0;
        while(x < (Math.min(m,n)+1)/2){
            xxx(matrix, x, m, n, list);
            x++;
        }
        return list;
    }
    
    private void xxx(int[][] matrix, int x, int m, int n, List<Integer> list){
        int i = x;
        int j = x;
        int mlen = m - 2*x;
        int nlen = n - 2*x;
        if(mlen == 1 && nlen == 1){
            list.add(matrix[i][j]);
            return;
        }
        if(mlen == 1){
            while(j < n - x){
                list.add(matrix[i][j]);
                j++;
            }
            return;
        }
        
        if(nlen == 1){
            while(i < m - x){
                list.add(matrix[i][j]);
                i++;
            }
            return;
        }
        

        
        while(j < n - x - 1){
            list.add(matrix[i][j]);
            j++;
        }
        
        while(i < m - x - 1){
            list.add(matrix[i][j]);
            i++;
        }
        
        while(j > x){
            list.add(matrix[i][j]);
            j--;
        }
        
        while(i > x){
            list.add(matrix[i][j]);
            i--;
        }
    }
}
