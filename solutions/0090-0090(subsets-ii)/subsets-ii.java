// Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
//
// Note: The solution set must not contain duplicate subsets.
//
// Example:
//
//
// Input: [1,2,2]
// Output:
// [
//   [2],
//   [1],
//   [1,2,2],
//   [2,2],
//   [1,2],
//   []
// ]
//
//


public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<Integer>());
        int start = 0;
        int count = 0;
        for(int i = 0; i < len; i++){
            int size = list.size();
            if(i != 0 && nums[i] == nums[i-1]){
                if(count == 0){
                    count = size/2;    
                }
                start += count;
            }else{
                count = 0;
                start = 0;
            }
            for(int j = start; j < size; j++){
                ArrayList<Integer> temp = new ArrayList(list.get(j));
                temp.add(nums[i]);
                list.add(temp);
            }
        }
        return list;
    }
}
