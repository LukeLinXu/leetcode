// Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
//
// You may assume no duplicates in the array.
//
// Example 1:
//
//
// Input: [1,3,5,6], 5
// Output: 2
//
//
// Example 2:
//
//
// Input: [1,3,5,6], 2
// Output: 1
//
//
// Example 3:
//
//
// Input: [1,3,5,6], 7
// Output: 4
//
//
// Example 4:
//
//
// Input: [1,3,5,6], 0
// Output: 0
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
