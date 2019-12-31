// Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
//
// Example:
//
//
// Input:  [1,2,3,4]
// Output: [24,12,8,6]
//
//
// Note: Please solve it without division and in O(n).
//
// Follow up:
// Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
//


public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] temp = new int[nums.length];
        temp[0] = 1;
        for(int i = 1; i < nums.length; i++){
            temp[i] = temp[i - 1] * nums[i - 1];
        }
        int right = 1;
        for(int i = nums.length - 2; i >= 0; i--){
            right = nums[i + 1] * right;
            temp[i] *= right;
        }
        return temp;
    }
}
