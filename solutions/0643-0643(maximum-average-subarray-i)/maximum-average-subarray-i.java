// Given an array consisting of n integers, find the contiguous subarray of given length k that has the maximum average value. And you need to output the maximum average value.
//
// Example 1:
//
//
// Input: [1,12,-5,-6,50,3], k = 4
// Output: 12.75
// Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
//
//
//  
//
// Note:
//
//
// 	1 <= k <= n <= 30,000.
// 	Elements of the given array will be in the range [-10,000, 10,000].
//
//
//  
//


class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int len = nums.length;
        int base = 0;
        int max = 0;
        for(int i = 0; i<k;i++){
            base += nums[i];
        }
        max = base;
        for(int i = 0; i < len-k; i++){
            int diff = nums[i+k]-nums[i];
            base += diff;
            max = Math.max(max, base);
        }
        return max*1.0/k;
    }
}
