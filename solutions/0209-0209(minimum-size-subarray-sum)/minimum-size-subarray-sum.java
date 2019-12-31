// Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
//
// Example: 
//
//
// Input: s = 7, nums = [2,3,1,2,4,3]
// Output: 2
// Explanation: the subarray [4,3] has the minimal length under the problem constraint.
//
// Follow up:
//
// If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n). 
//


public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int len = nums.length;
        int sum = 0;
        if(len == 0) return 0;
        for(int i =  1; i <= len; i++){
            for(int j = 0; j <= len - i; j++){
                if(j == 0){
                    sum = 0;
                    for(int k = 1; k <= i; k++){
                        sum += nums[j + k - 1];
                    }
                }else{
                    sum -= nums[j - 1];
                    sum += nums[j + i - 1];
                }
                if(sum >= s) return i;
            }
        }
        return 0;
    }
}
