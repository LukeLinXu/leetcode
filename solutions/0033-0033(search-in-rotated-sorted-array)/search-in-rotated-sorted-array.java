// You are given an integer array nums sorted in ascending order (with distinct values), and an integer target.
//
// Suppose that nums is rotated at some pivot unknown to you beforehand (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
//
// If target is found in the array return its index, otherwise, return -1.
//
//  
// Example 1:
// Input: nums = [4,5,6,7,0,1,2], target = 0
// Output: 4
// Example 2:
// Input: nums = [4,5,6,7,0,1,2], target = 3
// Output: -1
// Example 3:
// Input: nums = [1], target = 0
// Output: -1
//
//  
// Constraints:
//
//
// 	1 <= nums.length <= 5000
// 	-104 <= nums[i] <= 104
// 	All values of nums are unique.
// 	nums is guaranteed to be rotated at some pivot.
// 	-104 <= target <= 104
//
//


public class Solution {
    public int search(int[] nums, int target) {
        int len = nums.length;
        if(len == 0) return -1;
        if(len == 1){
            return nums[0]==target ? 0 : -1;
        } 
        int left = 0;
        int right = len - 1;
        int middle = 0;
        while(left < right){
            middle = (left+right)/2;
            if(nums[middle]==target) return middle;
            if(nums[middle] >= nums[left]){
                if(nums[middle] > target && target >= nums[left]){
                    right = middle - 1;
                }else{
                    left = middle + 1;
                }
            }else{
                if(nums[middle] < target && target <= nums[right]){
                    left = middle + 1;
                }else{
                    right = middle - 1;
                }
            }
        }
        
        return nums[left] == target ? left : -1;

    }
}
