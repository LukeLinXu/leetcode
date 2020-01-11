// Given an array arr, replace every element in that array with the greatest element among the elements to its right, and replace the last element with -1.
//
// After doing so, return the array.
//
//  
// Example 1:
// Input: arr = [17,18,5,4,6,1]
// Output: [18,6,6,6,1,-1]
//
//  
// Constraints:
//
//
// 	1 <= arr.length <= 10^4
// 	1 <= arr[i] <= 10^5
//


class Solution {
    /**
     * 直接
     */
    public int[] replaceElements(int[] arr) {
        int len = arr.length;
        int[] res = new int[len];
        int max = arr[len - 1];
        for(int i = 0; i < len - 1; i++){
            max = Math.max(arr[len-1 - i], max);
            res[len-1 - i - 1] = max;
        }
        res[len - 1] = -1;
        return res;
    }
}
