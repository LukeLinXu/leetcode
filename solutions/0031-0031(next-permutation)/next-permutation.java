// Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
//
// If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
//
// The replacement must be in-place and use only constant extra memory.
//
// Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
//
// 1,2,3 → 1,3,2
// 3,2,1 → 1,2,3
// 1,1,5 → 1,5,1
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
