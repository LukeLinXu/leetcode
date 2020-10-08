// Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
//
//  
// Example 1:
// Input: nums = [1,3,5,6], target = 5
// Output: 2
// Example 2:
// Input: nums = [1,3,5,6], target = 2
// Output: 1
// Example 3:
// Input: nums = [1,3,5,6], target = 7
// Output: 4
// Example 4:
// Input: nums = [1,3,5,6], target = 0
// Output: 0
// Example 5:
// Input: nums = [1], target = 0
// Output: 0
//
//  
// Constraints:
//
//
// 	1 <= nums.length <= 104
// 	-104 <= nums[i] <= 104
// 	nums contains distinct values sorted in ascending order.
// 	-104 <= target <= 104
//
//


public class Solution {
    public int searchInsert(int[] nums, int target) {
        int length = nums.length;
        if(length == 0) return 0;
        int left = 0;
        int right = length - 1;
        if(target > nums[right]) return right + 1;
        if(target < nums[left]) return left;
        
        int middle = left;
        while(left < right){
            if(right - left == 1){
                if(nums[right] == target) return right;
                if(nums[left] == target) return left;
                return left + 1;
            }
            middle = (left + right)/2;
            if(nums[middle] == target){
                return middle;
            }else if(nums[middle] > target){
                right = middle;
            }else{
                left = middle;
            }
        }
        return right;
    }
}
