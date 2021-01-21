// Given an integer array nums of unique elements, return all possible subsets (the power set).
//
// The solution set must not contain duplicate subsets. Return the solution in any order.
//
//  
// Example 1:
//
//
// Input: nums = [1,2,3]
// Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
//
//
// Example 2:
//
//
// Input: nums = [0]
// Output: [[],[0]]
//
//
//  
// Constraints:
//
//
// 	1 <= nums.length <= 10
// 	-10 <= nums[i] <= 10
// 	All the numbers of nums are unique.
//
//


public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int length = nums.length;
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for(int i = 0; i<Math.pow(2, length); i++){
            List<Integer> temp = new ArrayList<>();
            char[] chars = Integer.toBinaryString(i).toCharArray();
            int size = chars.length;
            for(int j = length - size; j<length;j++){
                if(chars[size - length + j] == '1'){
                    temp.add(nums[j]);
                }
            }
            list.add(temp);
        }
        return list;
    }
}
