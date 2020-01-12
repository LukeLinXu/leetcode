// We are given a list nums of integers representing a list compressed with run-length encoding.
//
// Consider each adjacent pair of elements [a, b] = [nums[2*i], nums[2*i+1]] (with i >= 0).  For each such pair, there are a elements with value b in the decompressed list.
//
// Return the decompressed list.
//
//  
// Example 1:
// Input: nums = [1,2,3,4]
// Output: [2,4,4,4]
//
//  
// Constraints:
//
//
// 	2 <= nums.length <= 100
// 	nums.length % 2 == 0
// 	1 <= nums[i] <= 100
//


class Solution {
    /**
     * 直接
     */
    public static int[] decompressRLElist(int[] nums) {
        int[] keys = new int[nums.length/2];
        int[] values = new int[nums.length/2];
        int count = 0;
        for(int i = 0; i < nums.length; i+=2){
            int key = nums[i+1];
            int value = nums[i];
            keys[i/2] = key;
            values[i/2] = value;
            count += value;
        }
        int[] res = new int[count];
        int index = 0;
        for(int i = 0; i < keys.length; i++){
            for(int j = 0; j < values[i]; j++){
                res[index] = keys[i];
                index++;
            }
        }
        return res;
    }
}
