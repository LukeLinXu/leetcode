// Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.
//
//  
//
//
// Example 1:
//
//
// Input: [-4,-1,0,3,10]
// Output: [0,1,9,16,100]
//
//
//
// Example 2:
//
//
// Input: [-7,-3,2,3,11]
// Output: [4,9,9,49,121]
//
//
//  
//
// Note:
//
//
// 	1 <= A.length <= 10000
// 	-10000 <= A[i] <= 10000
// 	A is sorted in non-decreasing order.
//
//
//


class Solution {
    public int[] sortedSquares(int[] A) {
        // for(int i = 0; i < A.length; i++){
        //     if(A.length > 1){
        //         for(int j = 1; j < A.length - i; j++){
        //             if(Math.abs(A[j - 1]) > Math.abs(A[j])){
        //                 int temp = A[j - 1];
        //                 A[j - 1] = A[j];
        //                 A[j] = temp;
        //             }
        //         }
        //     }
        //     int j = A.length - 1 - i;
        //     A[j] = A[j]*A[j];
        // }
        // return A;
        
        if(A.length == 0) return A;
        int[] result = new int[A.length];
        int i = 0;
        int j = A.length - 1;
        int k = A.length - 1;
        while(i <= j){
            if(Math.abs(A[i]) > Math.abs(A[j])){
                result[k] = A[i] * A[i];
                i++;
                
            }else{
                result[k] = A[j] * A[j];
                j--;
            }
            k--;
        }
        return result;
    }
}
