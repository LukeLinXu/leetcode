// Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
//
// Your algorithm's runtime complexity must be in the order of O(log n).
//
// If the target is not found in the array, return [-1, -1].
//
// Example 1:
//
//
// Input: nums = [5,7,7,8,8,10], target = 8
// Output: [3,4]
//
// Example 2:
//
//
// Input: nums = [5,7,7,8,8,10], target = 6
// Output: [-1,-1]
//


public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        if(len == 0 || (len == 1 && nums[0] != target)) return new int[]{-1, -1};
        int low = 0;
        int high = len - 1;
        int mid = 0;
        while(low < high){
            if(high - low == 1){
                if(nums[low] == target){
                    mid = low;
                    break;
                }else if(nums[high] == target){
                    mid = high;
                    break;
                }else{
                    return new int[]{-1, -1};
                }
            }
            mid = (low + high)/2;
            if(nums[mid] == target) break;
            if(nums[mid] > target){
                high = mid;
            }else{
                low = mid;
            }
        }
        low = mid;
        high = mid;
        while(low >= 0 && nums[low] == nums[mid]){
            low --;
        }
        if(low < 0 || nums[low] != nums[mid]) low++;
        while(high <= len - 1 && nums[high] == nums[mid]){
            high ++;
        }
        if(high > len - 1 || nums[high] != nums[mid]) high--;
        return new int[]{low, high};
    }
}
