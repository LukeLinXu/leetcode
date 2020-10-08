// Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
//
// If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).
//
// The replacement must be in place and use only constant extra memory.
//
//  
// Example 1:
// Input: nums = [1,2,3]
// Output: [1,3,2]
// Example 2:
// Input: nums = [3,2,1]
// Output: [1,2,3]
// Example 3:
// Input: nums = [1,1,5]
// Output: [1,5,1]
// Example 4:
// Input: nums = [1]
// Output: [1]
//
//  
// Constraints:
//
//
// 	1 <= nums.length <= 100
// 	0 <= nums[i] <= 100
//
//


public class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        if(len == 0 || len == 1) return;
        int i = len - 2;
        while(i >= 0){
            if(nums[i] < nums[i + 1]){
                break;
            }
            i --;
        }
        if(i >= 0){
            int j = len - 1;
            for(int k = i+1; k < len; k++){
                if(nums[k] <= nums[i]){
                    j = k - 1;
                    break;
                }
            }
            swap(nums, i, j);
            for(int m = i + 1; m <= (len+i)/2; m++){
                swap(nums, m, len-m+i);
            }
        }else{
            Arrays.sort(nums);
        }
    }
    
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
