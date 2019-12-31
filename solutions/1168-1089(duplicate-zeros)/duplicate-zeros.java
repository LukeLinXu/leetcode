// Given a fixed length array arr of integers, duplicate each occurrence of zero, shifting the remaining elements to the right.
//
// Note that elements beyond the length of the original array are not written.
//
// Do the above modifications to the input array in place, do not return anything from your function.
//
//  
//
// Example 1:
//
//
// Input: [1,0,2,3,0,4,5,0]
// Output: null
// Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
//
//
// Example 2:
//
//
// Input: [1,2,3]
// Output: null
// Explanation: After calling your function, the input array is modified to: [1,2,3]
//
//
//  
//
// Note:
//
//
// 	1 <= arr.length <= 10000
// 	0 <= arr[i] <= 9
//


class Solution {
  public static void duplicateZeros(int[] arr) {
        int len = arr.length;
        int shift = 0;
        boolean lastDigIs0 = false;
        for(int i = 0; i < len; i++){
            if(arr[i] == 0){
                shift++;
            }
            if(i + shift == len - 1){
                break;
            }
            if(i + shift == len){
                lastDigIs0 = true;
                shift--;
                break;
            }
        }
        for(int i = len - 1; i >= 0; i--){
            if((i == len - 1) && lastDigIs0 ){
                arr[i] = 0;
            }else {
                if(arr[i - shift] == 0){
                    arr[i] = 0;
                    arr[i - 1] = 0;
                    i--;
                    shift--;    
                    
                }else {
                    arr[i] = arr[i - shift];
                }
            }
        }
    }
}
