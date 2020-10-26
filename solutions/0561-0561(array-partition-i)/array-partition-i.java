// Given an integer array nums of 2n integers, group these integers into n pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn) which makes the sum of min(ai, bi) for all i from 1 to n as large as possible.
//
//  
// Example 1:
//
//
// Input: nums = [1,4,3,2]
// Output: 4
// Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
//
//
// Example 2:
//
//
// Input: nums = [6,2,6,5,1,2]
// Output: 9
//
//
//  
// Constraints:
//
//
// 	1 <= n <= 104
// 	nums.length == 2 * n
// 	-104 <= nums[i] <= 104
//
//


class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for(int i = 0; i < nums.length; i+=2){
            result += nums[i];
        }
        return result;
    }
}
