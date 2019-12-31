// Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
//
// Your algorithm should run in O(n) complexity.
//
// Example:
//
//
// Input: [100, 4, 200, 1, 3, 2]
// Output: 4
// Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
//
//


public class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        if(nums.length == 0) return 0;
        int maxLen = 0;
        int temp = 1;
        for(int i = 0;i<nums.length-1;i++){
            if(nums[i+1] ==  nums[i]) continue;
            if(nums[i+1] - nums[i] ==  1){
                temp++;
            }else{
                maxLen = Math.max(maxLen,temp);
                temp = 1;
            }
        }
        maxLen = Math.max(maxLen,temp);
        return maxLen;
    }
}
