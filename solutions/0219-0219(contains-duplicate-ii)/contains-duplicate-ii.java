// Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
//
//
// Example 1:
//
//
// Input: nums = [1,2,3,1], k = 3
// Output: true
//
//
//
// Example 2:
//
//
// Input: nums = [1,0,1,1], k = 1
// Output: true
//
//
//
// Example 3:
//
//
// Input: nums = [1,2,3,1,2,3], k = 2
// Output: false
//
//
//
//
//


class Solution {
// public boolean containsNearbyDuplicate(int[] nums, int k) {
    // if(nums.length == 0) return false;
    //     HashSet<Integer> map = new HashSet();
    //     for(int i = 0; i < Math.min(k+1, nums.length); i++){
    //         if(map.contains(nums[i])) return true;
    //         map.add(nums[i]);
    //     }
    //     for(int i = 1; i< nums.length-k;i++){
    //         map.remove(nums[i - 1]);
    //         if(map.contains(nums[i + k])) return true;
    //         map.add(nums[i + k]);
    //     }
    //     return false;
    // }
    
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && 
                nums[i] == nums[map.get(nums[i])] && 
                i - map.get(nums[i]) <= k)
                return true;
            map.put(nums[i], i);
        }
        return false;
    }
}
