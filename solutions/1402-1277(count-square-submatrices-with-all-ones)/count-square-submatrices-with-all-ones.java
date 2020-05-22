// Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.
//
//  
// Example 1:
//
//
// Input: matrix =
// [
//   [0,1,1,1],
//   [1,1,1,1],
//   [0,1,1,1]
// ]
// Output: 15
// Explanation: 
// There are 10 squares of side 1.
// There are 4 squares of side 2.
// There is  1 square of side 3.
// Total number of squares = 10 + 4 + 1 = 15.
//
//
// Example 2:
//
//
// Input: matrix = 
// [
//   [1,0,1],
//   [1,1,0],
//   [1,1,0]
// ]
// Output: 7
// Explanation: 
// There are 6 squares of side 1.  
// There is 1 square of side 2. 
// Total number of squares = 6 + 1 = 7.
//
//
//  
// Constraints:
//
//
// 	1 <= arr.length <= 300
// 	1 <= arr[0].length <= 300
// 	0 <= arr[i][j] <= 1
//
//


class Solution {
    /**
     * 我从左上顶角计算，并且按面积逐步增加，这个方法用右下顶角计算，并且利用了原有矩阵。所以需要注意的是，如果原题给出INT，但是只有0，1多半是要用int计算。
     */
    public int countSquares(int[][] A) {
        int res = 0;
        for (int i = 0; i < A.length; ++i) {
            for (int j = 0; j < A[0].length; ++j) {
                if (A[i][j] > 0 && i > 0 && j > 0) {
                    A[i][j] = Math.min(A[i - 1][j - 1], Math.min(A[i - 1][j], A[i][j - 1])) + 1;
                }
                res += A[i][j];
            }
        }
        return res;
    }
    /**
     * 直接
     */
    public int countSquares1(int[][] matrix) {
        HashSet<Integer> set = new HashSet<>();
        int count = 0;
        for(int i = 0;i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 1){
                    set.add(i*1000+j);
                    count++;
                }
            }
        }
        while (true){
            HashSet<Integer> nextSet = new HashSet<>();
            for (int item : set){
                int j = item%1000;
                int i = item/1000;
                boolean p1 = set.contains((i+1)*1000+(j));
                boolean p2 = set.contains((i)*1000+(j+1));
                boolean p3 = set.contains((i+1)*1000+(j+1));
                if(p1&&p2&&p3){
                    count++;
                    nextSet.add(item);
                }
            }
            if(nextSet.size() == 0){
                break;
            }else {
                set = nextSet;
            }
        }
        return count;
    }
}
