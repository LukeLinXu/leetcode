// Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
//
// (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
//
// Find the minimum element.
//
// You may assume no duplicate exists in the array.
//
// Example 1:
//
//
// Input: [3,4,5,1,2] 
// Output: 1
//
//
// Example 2:
//
//
// Input: [4,5,6,7,0,1,2]
// Output: 0
//
//


public class Solution {
    public int findMin(int[] nums) {
        int length = nums.length;
        if(length == 0) return 0;
        if(length == 1) return nums[0];
        int left = 0;
        int right = length - 1;
        int middle = 0;
        while(left < right){
            if(right - left == 1) return Math.min(nums[left], nums[right]);
            middle = (left + right)/2;
            if(nums[left] < nums[middle] && nums[middle] < nums[right]){
                return nums[0];
            }else if(nums[middle]>nums[left] && nums[middle]>nums[right]){
                left = middle;
            }else if(nums[middle]<nums[left] && nums[middle]<nums[right]){
                right = middle;
            }
        }
        return 0;
    }
}
