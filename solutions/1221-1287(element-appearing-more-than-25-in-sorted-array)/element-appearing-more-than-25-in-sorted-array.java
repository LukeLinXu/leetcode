// Given an integer array sorted in non-decreasing order, there is exactly one integer in the array that occurs more than 25% of the time.
//
// Return that integer.
//
//  
// Example 1:
// Input: arr = [1,2,2,6,6,6,6,7,10]
// Output: 6
//
//  
// Constraints:
//
//
// 	1 <= arr.length <= 10^4
// 	0 <= arr[i] <= 10^5
//


class Solution {
    /**
     * 直接
     */
    public int findSpecialInteger(int[] arr) {
        int count = arr.length/4;
        for(int i = 0; i < arr.length - count; i++){
            if(arr[i] == arr[i+count]){
                return arr[i];
            }
        }
        return -1;
    }
}
