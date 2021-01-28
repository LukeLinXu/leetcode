// Given an array nums with n integers, your task is to check if it could become non-decreasing by modifying at most one element.
//
// We define an array is non-decreasing if nums[i] <= nums[i + 1] holds for every i (0-based) such that (0 <= i <= n - 2).
//
//  
// Example 1:
//
//
// Input: nums = [4,2,3]
// Output: true
// Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
//
//
// Example 2:
//
//
// Input: nums = [4,2,1]
// Output: false
// Explanation: You can't get a non-decreasing array by modify at most one element.
//
//
//  
// Constraints:
//
//
// 	n == nums.length
// 	1 <= n <= 104
// 	-105 <= nums[i] <= 105
//
//


class Solution {
    public boolean checkPossibility(int[] nums) {
        int len = nums.length;
        if(len <= 2) return true;
        int count = 0;
        for(int i = 1; i<len; i++){
            if(nums[i-1] > nums[i]){
                count++;
                if(count > 1) return false;
                if(i == 1 || i == (len - 1)){
                    continue;
                }
                // found i - 1   i 
                //check i -2 i i 
                //check i - 1 i -1 i + 1
                boolean check1= nums[i - 2] <= nums[i];
                boolean check2 = nums[i-1] <= nums[i+1];
                if(!check1 && !check2){
                    return false;
                }
            }
        }
        return true;
    }
}
