// Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
//
// The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
//
// Note:
//
//
// 	Your returned answers (both index1 and index2) are not zero-based.
// 	You may assume that each input would have exactly one solution and you may not use the same element twice.
//
//
// Example:
//
//
// Input: numbers = [2,7,11,15], target = 9
// Output: [1,2]
// Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
//


public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if(numbers.length == 0) return null;
        int position = numbers.length - 1;
        if(target < numbers[position]){
            getPosition(numbers, target, 0);    
        }
        for(int i = 0; i <= position; i++){
            int need = target - numbers[i];
            int pp = getPosition(numbers, need, i);
            if(numbers[pp] == need) return new int[]{i+1, pp+1};
        }
        return new int[]{0, 0};
    }
    
    public int getPosition(int[] numbers, int target, int start){
        int left = start;
        int right = numbers.length - 1;
        int middle = right;
        while(left < right && right - left != 1){
            middle = (left + right)/2;
            if(numbers[middle] >= target){
                right = middle;
            }else{
                left = middle;
            }
        }
        return right;
    }
}
