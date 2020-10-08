// Given an integer array nums, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order.
//
// Return the shortest such subarray and output its length.
//
//  
// Example 1:
//
//
// Input: nums = [2,6,4,8,10,9,15]
// Output: 5
// Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
//
//
// Example 2:
//
//
// Input: nums = [1,2,3,4]
// Output: 0
//
//
// Example 3:
//
//
// Input: nums = [1]
// Output: 0
//
//
//  
// Constraints:
//
//
// 	1 <= nums.length <= 104
// 	-105 <= nums[i] <= 105
//
//


class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] temp = nums.clone();
        Arrays.sort(temp);
        int i = 0;
        int j = nums.length - 1;

        while(i <= j && nums[i] == temp[i]){
            i++;
        }
        while(i <= j && nums[j] == temp[j]){
            j--;
        }    

        return j - i + 1;
    }
}
