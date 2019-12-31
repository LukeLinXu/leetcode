// Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
//
// Example 1:
//
//
// Input: [2,3,-2,4]
// Output: 6
// Explanation: [2,3] has the largest product 6.
//
//
// Example 2:
//
//
// Input: [-2,0,-1]
// Output: 0
// Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
//


public class Solution {
  public static int maxProduct(int[] nums) {
        int firstNeg = -1;
        int lastNeg = -1;
        int negCount = 0;
        int max = Integer.MIN_VALUE;
        int s = -1;
        int e = -1;

        for(int i = 0; i < nums.length; i++){
            if(nums[i]<0){
                if(firstNeg == -1){
                    firstNeg = i;
                }else{
                    lastNeg = i;
                }
                negCount++;
                if(s == -1){
                    s = i;
                }else{
                    e = i;
                }
            }else if(nums[i] == 0){

                int temp = getMax(nums, s, e, firstNeg, lastNeg, negCount);
                s = -1;
                e = -1;
                firstNeg = -1;
                lastNeg = -1;
                negCount = 0;
                max = Math.max(max, temp);
                max = Math.max(max, 0);
            }else{
                if(s == -1){
                    s = i;
                }else{
                    e = i;
                }
            }
        }
        e = nums.length - 1;
        int temp = getMax(nums, s, e, firstNeg, lastNeg, negCount);
        max = Math.max(max, temp);
        return max;
    }

    private static int getMax(int[] nums, int s, int e, int first, int last, int count){
        if(s == -1) return 0;
        if(e == -1) return nums[s];
        if(s == e) return nums[s];
        if(count%2 == 0){
            return getProduct(nums, s, e);
        }else if(count == 1){
            if(first == s){
                return getProduct(nums, s + 1, e);
            }else if(first == e){
                return getProduct(nums, s, e - 1);
            }else{
                return Math.max(getProduct(nums, s, first - 1), getProduct(nums, first + 1, e));    
            }
        }else{
            int temp0 = getProduct(nums, s, first);
            int temp1 = getProduct(nums, last, e);
            if(temp0 <= temp1){
                return temp0*getProduct(nums, first + 1, last - 1);
            }else{
                return temp1*getProduct(nums, first+1, last-1);
            }
        }
    }

    private static int getProduct(int[] nums, int s, int e){
        if(s == e) return nums[s];
        int pro =  1;
        for(int i = s; i <=e; i++){
            pro *= nums[i];
        }
        return pro;
    }
}
