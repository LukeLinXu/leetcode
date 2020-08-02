// Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
//
// Example:
//
//
// Given nums = [-2, 0, 3, -5, 2, -1]
//
// sumRange(0, 2) -> 1
// sumRange(2, 5) -> -1
// sumRange(0, 5) -> -3
//
//
//  
// Constraints:
//
//
// 	You may assume that the array does not change.
// 	There are many calls to sumRange function.
// 	0 <= nums.length <= 10^4
// 	-10^5 <= nums[i] <= 10^5
// 	0 <= i <= j < nums.length
//
//


class NumArray {

    private int[] nums;
    public NumArray(int[] nums) {
        this.nums = nums;
    }
    
    public int sumRange(int i, int j) {
        if(i>j || i>=nums.length || j>=nums.length){
            return 0;
        }
        int sums = 0;
        for(int k = i; k <= j; k++){
            sums+=nums[k];
        }
        return sums;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
