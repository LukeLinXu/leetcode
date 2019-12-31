//
// Given an unsorted array of integers, find the length of longest continuous increasing subsequence (subarray).
//
//
// Example 1:
//
// Input: [1,3,5,4,7]
// Output: 3
// Explanation: The longest continuous increasing subsequence is [1,3,5], its length is 3. 
// Even though [1,3,5,7] is also an increasing subsequence, it's not a continuous one where 5 and 7 are separated by 4. 
//
//
//
// Example 2:
//
// Input: [2,2,2,2,2]
// Output: 1
// Explanation: The longest continuous increasing subsequence is [2], its length is 1. 
//
//
//
// Note:
// Length of the array will not exceed 10,000.
//


class Solution {
public int findLengthOfLCIS(int[] nums) {
        int len = nums.length;
        if(len < 2) return len;
        
        int count = 1;
        int max = 0;
        for(int i = 0; i < len - 1;i++){
            if(nums[i] < nums[i+1]){
                count++;
            }else {
                count = 1;
            }
            max = Math.max(count, max);
        }
        return max;
    }
}
