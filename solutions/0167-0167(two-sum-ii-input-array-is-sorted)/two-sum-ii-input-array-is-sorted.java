// Given an array of integers numbers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
//
// Return the indices of the two numbers (1-indexed) as an integer array answer of size 2, where 1 <= answer[0] < answer[1] <= numbers.length.
//
// You may assume that each input would have exactly one solution and you may not use the same element twice.
//
//  
// Example 1:
//
//
// Input: numbers = [2,7,11,15], target = 9
// Output: [1,2]
// Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
//
//
// Example 2:
//
//
// Input: numbers = [2,3,4], target = 6
// Output: [1,3]
//
//
// Example 3:
//
//
// Input: numbers = [-1,0], target = -1
// Output: [1,2]
//
//
//  
// Constraints:
//
//
// 	2 <= numbers.length <= 3 * 104
// 	-1000 <= numbers[i] <= 1000
// 	numbers is sorted in increasing order.
// 	-1000 <= target <= 1000
// 	Only one valid answer exists.
//
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
