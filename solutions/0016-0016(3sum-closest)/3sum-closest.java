// Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
//
//  
// Example 1:
//
//
// Input: nums = [-1,2,1,-4], target = 1
// Output: 2
// Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
//
//
//  
// Constraints:
//
//
// 	3 <= nums.length <= 10^3
// 	-10^3 <= nums[i] <= 10^3
// 	-10^4 <= target <= 10^4
//
//


public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        int sum = 0;
        if(len <= 3){
            for(int i : nums){
                sum += i;
            }
            return sum;
        }
        Arrays.sort(nums);
        sum = nums[0] + nums[1]+ nums[2];
        for(int i = 0; i < len - 2; i++){
            int start = i + 1;
            int end = len - 1;
            while(start < end){
               int x= nums[start]+nums[end]+nums[i];
               if(x > target){
                   end --;
               }else if(x < target){
                   start ++;
               }else{
                   return target;
               }
               if(Math.abs(sum -  target)>Math.abs(x - target)){
                   sum = x;
               }
            }
        }
        return sum;
    }
    
    private int dd(int[] nums, int target, int start, int end, int subValue){
        if(start == end) return subValue+nums[end];
        int need = target - subValue;
        if(need <= nums[start]) return subValue+nums[start];
        if(need >= nums[end]) return subValue+nums[end];
        while(start < end){
            if(end - start == 1){
                int x = subValue + nums[start];
                int y = subValue + nums[end];
                if(Math.abs(x - target) > Math.abs(y - target)){
                    return y;
                }else{
                    return x;
                }
            }else{
                int mid = (start + end)/2;    
                if(nums[mid] > need){
                    end = mid;
                }else{
                    start = mid;
                }
            }
            
        }
        return 0;
    }
}
