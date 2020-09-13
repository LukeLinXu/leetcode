// Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
//
// Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
//
// Follow up:
//
//
// 	Could you solve this problem without using the library's sort function?
// 	Could you come up with a one-pass algorithm using only O(1) constant space?
//
//
//  
// Example 1:
// Input: nums = [2,0,2,1,1,0]
// Output: [0,0,1,1,2,2]
// Example 2:
// Input: nums = [2,0,1]
// Output: [0,1,2]
// Example 3:
// Input: nums = [0]
// Output: [0]
// Example 4:
// Input: nums = [1]
// Output: [1]
//
//  
// Constraints:
//
//
// 	n == nums.length
// 	1 <= n <= 300
// 	nums[i] is 0, 1, or 2.
//
//


public class Solution {
    public void sortColors(int[] nums) {
        int c0 = 0;
        int c1 = 0;
        int c2 = 0;
        for(int i : nums){
            if(i == 0) c0++;
            if(i == 1) c1++;
            if(i == 2) c2++;
        }
        for(int i = 0; i < nums.length; i++){
            if(c0 != 0){
                nums[i] = 0;
                c0--;
            }else if(c1 != 0){
                nums[i] = 1;
                c1--;
            }else if(c2 != 0){
                nums[i] = 2;
                c2--;
            }
        }
    }
}
