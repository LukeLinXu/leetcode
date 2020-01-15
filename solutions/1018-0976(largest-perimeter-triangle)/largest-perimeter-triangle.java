// Given an array A of positive lengths, return the largest perimeter of a triangle with non-zero area, formed from 3 of these lengths.
//
// If it is impossible to form any triangle of non-zero area, return 0.
//
//  
//
//
//
//
//
// Example 1:
//
//
// Input: [2,1,2]
// Output: 5
//
//
//
// Example 2:
//
//
// Input: [1,2,1]
// Output: 0
//
//
//
// Example 3:
//
//
// Input: [3,2,3,4]
// Output: 10
//
//
//
// Example 4:
//
//
// Input: [3,6,2,3]
// Output: 8
//
//
//  
//
// Note:
//
//
// 	3 <= A.length <= 10000
// 	1 <= A[i] <= 10^6
//
//
//
//
//


class Solution {
    /**
     * 直接
     */
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        int len = A.length;
        int index = len - 1;
        while (index-2>=0){
            if(A[index] < A[index - 1] + A[index - 2]){
                return A[index]+A[index-1]+A[index-2];
            }else {
                index--;
            }
        }
        return 0;
    }
}
