// Given an array of non-negative integers, you are initially positioned at the first index of the array.
//
// Each element in the array represents your maximum jump length at that position.
//
// Your goal is to reach the last index in the minimum number of jumps.
//
// Example:
//
//
// Input: [2,3,1,1,4]
// Output: 2
// Explanation: The minimum number of jumps to reach the last index is 2.
//     Jump 1 step from index 0 to 1, then 3 steps to the last index.
//
// Note:
//
// You can assume that you can always reach the last index.
//


public class Solution {
    public int jump(int[] nums) {
        int len = nums.length;
        if(len == 0 || len == 1) return 0;
        int count = 0;
        int low = len - 1;
        while(true){
            boolean p = false;
            for(int i = 0; i < low; i++){
                if(i + nums[i] >= low){
                    low = i;
                    p = true;
                    break;
                }
            }
            if(!p) return 0;
            count ++;
            if(low == 0) return count;
        }

    }
}
