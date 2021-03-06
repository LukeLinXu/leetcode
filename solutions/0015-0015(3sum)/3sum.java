// Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
//
// Notice that the solution set must not contain duplicate triplets.
//
//  
// Example 1:
// Input: nums = [-1,0,1,2,-1,-4]
// Output: [[-1,-1,2],[-1,0,1]]
// Example 2:
// Input: nums = []
// Output: []
// Example 3:
// Input: nums = [0]
// Output: []
//
//  
// Constraints:
//
//
// 	0 <= nums.length <= 3000
// 	-105 <= nums[i] <= 105
//
//


public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int target = 0;
        ArrayList<List<Integer>> list = new ArrayList<>();
        int len = nums.length;
        if(len < 3) return list;
        Arrays.sort(nums);
        for(int i = 0; i < len - 2; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int s = i + 1;
            int e = len - 1;
            while(s < e){
                if(s!= (i+1) && nums[s] == nums[s - 1]){
                    s++;continue;  
                } 
                int sum = nums[i] + nums[s] + nums[e];
                if(sum > target){
                    e --;
                }else if(sum < target){
                    s ++;
                }else{
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[s]);
                    temp.add(nums[e]);
                    list.add(temp);
                    s++;
                    e--;
                }
            }
        }
        return list;
    }
}
