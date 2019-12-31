// Given a set of distinct integers, nums, return all possible subsets (the power set).
//
// Note: The solution set must not contain duplicate subsets.
//
// Example:
//
//
// Input: nums = [1,2,3]
// Output:
// [
//   [3],
//   [1],
//   [2],
//   [1,2,3],
//   [1,3],
//   [2,3],
//   [1,2],
//   []
// ]
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
