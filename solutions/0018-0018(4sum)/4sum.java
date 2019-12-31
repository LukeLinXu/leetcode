// Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
//
// Note:
//
// The solution set must not contain duplicate quadruplets.
//
// Example:
//
//
// Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
//
// A solution set is:
// [
//   [-1,  0, 0, 1],
//   [-2, -1, 1, 2],
//   [-2,  0, 0, 2]
// ]
//
//


public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        ArrayList<List<Integer>> list = new ArrayList<>();
        int len = nums.length;
        if(len < 4) return list;
        Arrays.sort(nums);
        for(int j = 0; j < len - 3; j++){
            if(j > 0 && nums[j] == nums[j-1]) continue;
            for(int i = j+1; i < len - 2; i++){
                if(i > j+1 && nums[i] == nums[i-1]) continue;
                int s = i + 1;
                int e = len - 1;
                while(s < e){
                    if(s!= (i+1) && nums[s] == nums[s - 1]){
                        s++;continue;  
                    } 
                    int sum = nums[j] + nums[i] + nums[s] + nums[e];
                    if(sum > target){
                        e --;
                    }else if(sum < target){
                        s ++;
                    }else{
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(nums[j]);
                        temp.add(nums[i]);
                        temp.add(nums[s]);
                        temp.add(nums[e]);
                        list.add(temp);
                        s++;
                        e--;
                    }
                }
            }
        }
        return list;
    }
}
