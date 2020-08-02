// Given an unsorted integer array, find the smallest missing positive integer.
//
// Example 1:
//
//
// Input: [1,2,0]
// Output: 3
//
//
// Example 2:
//
//
// Input: [3,4,-1,1]
// Output: 2
//
//
// Example 3:
//
//
// Input: [7,8,9,11,12]
// Output: 1
//
//
// Follow up:
//
// Your algorithm should run in O(n) time and uses constant extra space.
//


public class Solution {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        if(len == 0) return 1;
        if(len == 1) return nums[0]==1 ? 2 : 1;
        int pos1 = find1(nums, len);
        if(pos1 == -1) return 1;
        int current = 1;
        for(int i = pos1; i < len; i++){
            if(nums[i] == current + 1){
                current ++;
            }else if(nums[i] != current){
                return current + 1;
            }
        }
        return nums[len - 1] + 1;
    }
    
    private int find1(int[] nums, int len){
        int left = 0;
        int right = len - 1;
        while(left <= right){
            int middle = (left + right)/2;
            if(nums[middle] == 1){
                return middle;
            }else if(nums[middle] > 1){
                right = middle - 1;
            }else{
                left = middle + 1;
            }
        }
        return -1;
    }
}
