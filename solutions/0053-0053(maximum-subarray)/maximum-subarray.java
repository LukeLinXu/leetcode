// Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
//
// Example:
//
//
// Input: [-2,1,-3,4,-1,2,1,-5,4],
// Output: 6
// Explanation: [4,-1,2,1] has the largest sum = 6.
//
//
// Follow up:
//
// If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
//


public class Solution {
    public int maxSubArray(int[] nums) {
        int length = nums.length;
        int[] max = new int[length];
        int res = nums[0];
        max[0] = nums[0];
        for(int i = 1; i < length; i++){
            max[i] = nums[i] + Math.max(max[i - 1], 0);
            res = Math.max(res, max[i]);
        }
        return res;
    }
}
