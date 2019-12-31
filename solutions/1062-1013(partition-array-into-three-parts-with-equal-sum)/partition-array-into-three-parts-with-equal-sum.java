// Given an array A of integers, return true if and only if we can partition the array into three non-empty parts with equal sums.
//
// Formally, we can partition the array if we can find indexes i+1 < j with (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1])
//
//  
//
// Example 1:
//
//
// Input: [0,2,1,-6,6,-7,9,1,2,0,1]
// Output: true
// Explanation: 0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
//
//
//
// Example 2:
//
//
// Input: [0,2,1,-6,6,7,9,-1,2,0,1]
// Output: false
//
//
//
// Example 3:
//
//
// Input: [3,3,6,5,-2,2,5,1,-9,4]
// Output: true
// Explanation: 3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4
//
//
//
//
//  
//
// Note:
//
//
// 	3 <= A.length <= 50000
// 	-10000 <= A[i] <= 10000
//


class Solution {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for(int i : A){
            sum+= i;
        }
        if(sum%3 != 0) return false;
        int part = sum/3;
        int index1 = findIndex(A, 0, part);
        if(index1 == -1) return false;
        int index2 = findIndex(A, index1 + 1, part);
        return index2 != -1;
    }
    
    private int findIndex(int[] A, int start, int targetSum){
        for(int i = start; i < A.length; i++){
            targetSum -= A[i];
            if(targetSum == 0) return i;
        }
        return -1;
    }
}
